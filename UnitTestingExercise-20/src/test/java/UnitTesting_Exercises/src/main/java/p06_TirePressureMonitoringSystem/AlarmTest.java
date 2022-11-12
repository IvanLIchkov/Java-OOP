package UnitTesting_Exercises.src.main.java.p06_TirePressureMonitoringSystem;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class AlarmTest {

    @Test
    public void testAlarmOnWithLowPressure(){
        Sensor sensorWithNormalPressure = Mockito.mock(Sensor.class);
        when(sensorWithNormalPressure.popNextPressurePsiValue()).thenReturn(12.0);
        Alarm alarm = new Alarm(sensorWithNormalPressure);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmOnWithNormalPressure(){
        Sensor sensorWithNormalPressure = Mockito.mock(Sensor.class);
        when(sensorWithNormalPressure.popNextPressurePsiValue()).thenReturn(20.0);
        Alarm alarm = new Alarm(sensorWithNormalPressure);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithHighPressure(){
        Sensor sensorWithHighPressure = Mockito.mock(Sensor.class);
        when(sensorWithHighPressure.popNextPressurePsiValue()).thenReturn(100.0);
        Alarm alarm = new Alarm(sensorWithHighPressure);
        assertTrue(alarm.getAlarmOn());
    }
}