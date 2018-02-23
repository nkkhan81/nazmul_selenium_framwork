package com.naz.classwork_106_darkskyTimeline;

import com.naz.base.BasePaseJS;
import com.naz.base.DriverWrapperChrome;
import org.testng.annotations.Test;

import static com.naz.base.BasePaseJS.setBrowserWindowSize;

/**
 * Created by nkkhan on 2/5/18.
 */
public class verifyScrollSetbrowserJsclick extends DriverWrapperChrome{

    @Test
    public void verifyScroll() throws InterruptedException {
        BasePaseJS.ScrollDownPage(0,350);
    }

    //setBrowserWindowSize
    //remove extending DriverWrapper class before run this test. otherwise it will open two window
    @Test
    public void verifyWindowSize() throws InterruptedException {
        setBrowserWindowSize(480,300,"https://www.google.com");
    }
}
