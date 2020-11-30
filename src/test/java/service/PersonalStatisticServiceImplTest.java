package service;

import com.repository.statistic.StatisticRepo;
import com.service.statistic.StatisticService;
import com.service.statistic.StatisticServiceImpl;
import com.service.test.TestService;
import com.service.user.UserService;
import org.junit.Test;
import org.mockito.Mock;


public class PersonalStatisticServiceImplTest {
    @Mock
    private StatisticRepo statisticRepo;
    private StatisticService statisticService;
    private TestService testService;
    private UserService userService;

    public PersonalStatisticServiceImplTest() {
        this.statisticService = new StatisticServiceImpl(statisticRepo);
        this.testService = testService;
        this.userService = userService;
    }

    @Test
    public void getPersonalStatistic(){
    }

}
