import errno
import time
from select import poll, POLLIN
import xwiimote

# display a constant
print "=== " + xwiimote.NAME_CORE + " ==="

# list wiimotes and remember the first one
try:
    mon = xwiimote.monitor(True, True)
    print "mon fd", mon.get_fd(False)
    ent = mon.poll()
    firstwiimote = ent
    while ent is not None:
        print "Found device: " + ent
        ent = mon.poll()
except SystemError as e:
    print "ooops, cannot create monitor (", e, ")"

# continue only if there is a wiimote
if firstwiimote is None:
    print "No wiimote to read"
    exit(0)

# create a new iface
try:
    dev = xwiimote.iface(firstwiimote)
except IOError as e:
    print "ooops,", e
    exit(1)

# display some information and open the iface
try:
    print "syspath:" + dev.get_syspath()
    fd = dev.get_fd()
    print "fd:", fd
    print "opened mask:", dev.opened()
    dev.open(dev.available() | xwiimote.IFACE_WRITABLE)
    print "opened mask:", dev.opened()
except SystemError as e:
    print "ooops", e
    exit(1)

# read some values
p = poll()
p.register(fd, POLLIN)
evt = xwiimote.event()
n = 0
record = False
output = ""
outputFile = None
startTime = 0
while n < 2:
    p.poll()
    try:
        dev.dispatch(evt)
        if evt.type == xwiimote.EVENT_KEY:
            key, state = evt.get_key()
            if (key == xwiimote.KEY_A and state == 1):
                if not record:
                    print "RECORD"
                    record = True
                    output = ""
                    startTime = int(round(time.time() * 1000))
                else:
                    print "STOP RECORD"
                    record = False
                    outputFile = open("../data/record.txt", "w")
                    outputFile.write(output)
                    outputFile.close()
                    n = 2
            elif (record and key == xwiimote.KEY_B):
                if state == 1:
                    print "START"
                    output += str(int(round(time.time() * 1000)) - startTime) + " START\n"
                elif state == 0:
                    print "END"
                    output += str(int(round(time.time() * 1000)) - startTime) + " END\n"
        elif evt.type == xwiimote.EVENT_ACCEL:
            x, y, z = evt.get_abs(0)
            output += str(int(round(time.time() * 1000)) - startTime) + " " + str(x) + " " + str(y) + " " + str(z) + "\n"
        elif evt.type == xwiimote.EVENT_GONE:
            print "Gone"
            n = 2
    except IOError as e:
        if e.errno != errno.EAGAIN:
            print "Bad"

exit(0)
