package com.revature.mockito.audio;

//import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

//import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class VolumeUtilTests {

    @Mock
    private AudioManager audioManager;

    @Test
    void testNormalRingerIsMaximized() {
        // 1.) Ensure AudioManager gets mocked
        audioManager = Mockito.mock(AudioManager.class);

        // 2.) Configure AudioManager to return RINGER_MODE_NORMAL if getRingerMode is
        // called
        when(audioManager.getRingerMode()).thenReturn(RINGER_MODE.RINGER_MODE_NORMAL);

        // 3.) Configure AudioManager to return 100 if getStreamMaxVolume() is called
        when(audioManager.getStreamMaxVolume()).thenReturn(100);

        // 4.) Call VolumeUtil.maximizeVolume with AudioManager -> code under test
        VolumeUtil.maximizeVolume(audioManager);

        // 5.) Verify that setStreamVolume(100) was called on audioManager
        verify(audioManager).setStreamVolume(100);
    }

    @Test
    void testSilentRingerIsNotDisturbed() {
        // 1.) Ensure AudioManager gets mocked
        audioManager = Mockito.mock(AudioManager.class);

        // 2.) Configure AudioManager to return "RINGER_MODE_SILENT" if getRingerMode is
        // called
        when(audioManager.getRingerMode()).thenReturn(RINGER_MODE.RINGER_MODE_SILENT);

        // 3.) Call VolumeUtil.maximizeVolume with audioManager
        VolumeUtil.maximizeVolume(audioManager);

        // 4.) Verify that getRingerMode() is called on the mock
        verify(audioManager).getRingerMode();

        // 5.) Ensure that nothing more was called
        verifyNoMoreInteractions(audioManager);
    }
}
