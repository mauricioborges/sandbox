package pomodoro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pomodoro.domain.Alarm;

import java.util.Date;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"pomodoro.xml"});

        Alarm alarm = context.getBean("alarm", Alarm.class);
        alarm.startCountingAt(new Date().getTime());
        while (alarm.timeLeft() > 0) {
        }
        System.out.println("acaboooou, é tetraaaa");
    }

}
