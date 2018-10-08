
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sherlock.www.common.exception.MemberServiceException;
import com.sherlock.www.entity.Memberinfo;
import com.sherlock.www.service.IMemberService;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestTransaction  extends AbstractJUnit4SpringContextTests{
    @Autowired
    private IMemberService userService;
    @Test
    public void addSave() throws MemberServiceException{

        Memberinfo login = userService.login("1", "111111");
        System.out.println(login);
    }
 }
