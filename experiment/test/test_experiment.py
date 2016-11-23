"""This script contains tests for the Experiment class"""

import unittest
from src.experiment import Experiment

# pylint: disable=R0904
class TestExperiment(unittest.TestCase):
    """A class that tests the class Experiment"""
    def test_accel(self):
        """Tests the method accel"""
        experiment = Experiment()
        experiment.accel(80, 48, 97)
        experiment.accel(3, 42, 79)
        self.assertRegex(
            experiment.get_output(),
            '^[0-9]* 80 48 97\n[0-9]* 3 42 79\n$'
        )

    def test_press_b_success(self):
        """Tests the method press_b_down"""
        experiment = Experiment()
        experiment.accel(80, 48, 97)
        experiment.press_b_down()
        experiment.accel(3, 42, 79)
        experiment.press_b_up()
        experiment.accel(56, 21, 43)
        experiment.press_b_down()
        experiment.accel(62, 32, 28)
        experiment.press_b_up()
        self.assertRegex(
            experiment.get_output(),
            '^[0-9]* 80 48 97\n[0-9]* START 0\n[0-9]* 3 42 79\n[0-9]* END 0' \
            '\n[0-9]* 56 21 43\n[0-9]* START 1\n[0-9]* 62 32 28\n[0-9]* END ' \
            '1\n$'
        )

if __name__ == "__main__":
    unittest.main()
