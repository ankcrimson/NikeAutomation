import os
import unittest

from appium import webdriver
from appium.webdriver.common.touch_action import TouchAction
from appium.webdriver.common.multi_action import MultiAction

from time import sleep

# Returns abs path relative to this file and not cwd
PATH = lambda p: os.path.abspath(
    os.path.join(os.path.dirname(__file__), p)
)

class ComplexAndroidTests(unittest.TestCase):
    def setUp(self):
        desired_caps = {}
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '4.2'
        desired_caps['deviceName'] = 'Android Emulator'
        desired_caps['device'] = 'selendroid'
        desired_caps['app'] = PATH(
            'selendroid-test-app.apk'
        )

        self.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)

    def tearDown(self):
        self.driver.quit()

    def test_scroll(self):
        sleep(2)
        els = self.driver.find_element_by_class_name('android.widget.ImageButton')
        els.click()
        sleep(10)
        
        
        
        btn = self.driver.find_element_by_class_name('android.webkit.WebView')
        btn.click()


        sleep(10)

        webview = self.driver.contexts
        print ('>>%s<<' % len(webview))
        contexts = self.driver.contexts
        self.driver.switch_to.context('WEBVIEW')

        e1 = TouchAction()
        e1.press(x=150, y=100).release()

        e2 = TouchAction()
        e2.press(x=250, y=100).release()


        smile = TouchAction()
        smile.press(x=400, y=800) \
            .move_to(x=-1, y=1) \
            .move_to(x=-1, y=1) \
            .move_to(x=-1, y=1) \
            .move_to(x=-1, y=1) \
            .move_to(x=-1, y=1) \
            .move_to(x=-2, y=1) \
            .move_to(x=-2, y=1) \
            .move_to(x=-2, y=1) \
            .move_to(x=-2, y=1) \
            .move_to(x=-2, y=1) \
            .move_to(x=-3, y=1) \
            .move_to(x=-3, y=1) \
            .move_to(x=-3, y=1) \
            .move_to(x=-3, y=1) \
            .move_to(x=-3, y=1) \
            .move_to(x=-4, y=1) \
            .move_to(x=-4, y=1) \
            .move_to(x=-4, y=1) \
            .move_to(x=-4, y=1) \
            .move_to(x=-4, y=1) \
            .move_to(x=-5, y=1) \
            .move_to(x=-5, y=1) \
            .move_to(x=-5, y=1) \
            .move_to(x=-5, y=1) \
            .move_to(x=-5, y=1) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=-1) \
            .move_to(x=-5, y=-1) \
            .move_to(x=-5, y=-1) \
            .move_to(x=-5, y=-1) \
            .move_to(x=-5, y=-1) \
            .move_to(x=-4, y=-1) \
            .move_to(x=-4, y=-1) \
            .move_to(x=-4, y=-1) \
            .move_to(x=-4, y=-1) \
            .move_to(x=-4, y=-1) \
            .move_to(x=-3, y=-1) \
            .move_to(x=-3, y=-1) \
            .move_to(x=-3, y=-1) \
            .move_to(x=-3, y=-1) \
            .move_to(x=-3, y=-1) \
            .move_to(x=-2, y=-1) \
            .move_to(x=-2, y=-1) \
            .move_to(x=-2, y=-1) \
            .move_to(x=-2, y=-1) \
            .move_to(x=-2, y=-1) \
            .move_to(x=-1, y=-1) \
            .move_to(x=-1, y=-1) \
            .move_to(x=-1, y=-1) \
            .move_to(x=-1, y=-1) \
            .move_to(x=-1, y=-1)
        smile.release()
        ma = MultiAction(self.driver)
        ma.add(e1,e2,smile)
        ma.perform()
        sleep(10)



if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(ComplexAndroidTests)
    unittest.TextTestRunner(verbosity=2).run(suite)