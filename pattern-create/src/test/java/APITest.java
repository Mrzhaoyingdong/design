import com.zhaoyd6.patternface.door.Builder;
import com.zhaoyd6.patternface.door.IMenu;
import org.junit.Test;

public class APITest {


    @Test
    public void test(){
        Builder builder = new Builder();
        IMenu iMenu = builder.levelOne(32.2);
        IMenu iMenu1 = builder.levelTwo(32.2);
        IMenu iMenu2 = builder.levelThree(32.2);
        System.out.println(iMenu.getDetail());
        System.out.println(iMenu1.getDetail());
        System.out.println(iMenu2.getDetail());
    }
}
