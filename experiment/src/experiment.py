"""This script contains the Experiment class"""

import time

class Experiment(object):
    """A class that represents a experiment with accel data"""
    def __init__(self):
        self.output = ""
        self.task_index = 0
        self.start_time = int(round(time.time() * 1000))
        self.tasks = [
            "Please perform _Figure 1_",
            "Please perform _Figure 2_",
            "Please perform _Figure 3_",
            "Please perform _Figure 4_",
            "Please perform _Figure 5_",
            "Please perform _Figure 6_",
            "Please perform _Figure 7_",
            "Please perform _Figure 8_",
            "Please go around the table once and perform _Figure 1_ afterwards",
            "Please sit down on the ground, get up again and perform _Figure " \
            "2_ afterwards",
            "Please turn around your own axis and perform _Figure 3_ afterwar" \
            "ds",
            "Please sit on an office chair, turn around your own axis once an" \
            "d perform _Figure 4_ afterwards",
            "Please stretch your arms times up, then back to the floor and pe" \
            "rform _Figure 5_ afterwards",
            "Please lie down on the floor, get up again and perform _Figure 6" \
            "_ afterwards",
            "Please get on a chair, down again and perform _Figure 7_ afterwa" \
            "rds",
            "Please do as if you drink something from a cup and perform _Figu" \
            "re 8_ afterwards"
        ]
        self.button_b_down = False

    def accel(self, x_value, y_value, z_value):
        """Store accel data"""
        self.output += self.__get_experiment_time_string() + " " \
        + str(x_value) + " " + str(y_value) + " " + str(z_value) + "\n"

    def press_b_down(self):
        """Handle B button pressed down"""
        if self.button_b_down:
            raise Exception('Button B is already down.')
        self.button_b_down = True
        self.output += (self.__get_experiment_time_string() + " START " \
        + str(self.task_index) + "\n")

    def press_b_up(self):
        """Handle B button pressed up"""
        if not self.button_b_down:
            raise Exception('Button B is already up.')
        self.button_b_down = False
        self.output += self.__get_experiment_time_string() + " END " \
        + str(self.task_index) + "\n"
        self.task_index = self.task_index + 1
        self.__request_current_task()

    def get_output(self):
        """Returns the output of the experiment"""
        return self.output

    def __request_current_task(self):
        """Prints the current task description"""
        print self.tasks[self.task_index]

    def __get_experiment_time_string(self):
        """Returns the current experiment time as string"""
        return str(int(round(time.time() * 1000)) - self.start_time)
