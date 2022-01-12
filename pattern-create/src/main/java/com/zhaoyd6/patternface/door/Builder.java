package com.zhaoyd6.patternface.door;

import com.zhaoyd6.patternface.door.ceiling.LevelOneCeiling;
import com.zhaoyd6.patternface.door.ceiling.LevelTwoCeiling;
import com.zhaoyd6.patternface.door.coat.DuluxCoat;
import com.zhaoyd6.patternface.door.coat.LiBangCoat;
import com.zhaoyd6.patternface.door.floor.ShengXiangFloor;
import com.zhaoyd6.patternface.door.tile.DongPengTile;
import com.zhaoyd6.patternface.door.tile.MarcoPoloTile;

/**
 * <p>
 * 建造者模式
 *
 * 建造者模式所完成的内容就是
 * 将多个简单对象通过一步步的组装，构建出一个
 * 复杂对象的过程
 *
 * 将一个复杂的构建与其表示相分离。使得同样的构建过程
 * 可以建造创建不同的表示
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/8/26 4:08 下午
 *
 */


public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new DuluxCoat())             // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }

}
