import com.zhaoyd.cook.XiaoEr;
import com.zhaoyd.cook.impl.GuangDongCook;
import com.zhaoyd.cook.impl.JiangSuCook;
import com.zhaoyd.cook.impl.ShanDongCook;
import com.zhaoyd.cook.impl.SiChuanCook;
import com.zhaoyd.cuisine.ICuisine;
import com.zhaoyd.cuisine.impl.GuangDoneCuisine;
import com.zhaoyd.cuisine.impl.JiangSuCuisine;
import com.zhaoyd.cuisine.impl.ShanDongCuisine;
import com.zhaoyd.cuisine.impl.SiChuanCuisine;
import org.junit.Test;

/**
 *  @Description: 单元测试
 *  @author: zhao_yd
 *  @Date: 2021/8/11 3:11 下午
 *
 */

public class APITest {

    @Test
    public void test(){

        //菜系
        ICuisine guangDoneCuisine = new GuangDoneCuisine(new GuangDongCook());
        ICuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ICuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        ICuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        //点单
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangDoneCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);

        //下单
        xiaoEr.placeOrder();
    }


}
