/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

/**
 * 有 1000 只水桶，其中有且只有一桶装的含有毒药，其余装的都是水。它们从外观看起来都一样。如果小猪喝了毒药，它会在 15 分钟内死去。
 * <p>
 * 问题来了，如果需要你在一小时内，弄清楚哪只水桶含有毒药，你最少需要多少只猪？
 *
 * @author wangyz
 * @version DrinkWater.java, v 0.1 2019-12-05 15:28
 */
public class DrinkWater {


    /**
     * 首先来分析这道题，先用逆向思维来分析，一只猪一个小时可以试出多少桶水
     *       15分钟死       30分钟死      45分钟死      60分钟死    最终活了下来
     *       可以看到如果一只猪一个小时活了下来那么可以验5桶水
     *
     *       那么2只猪呢，两只猪可以这样理解，每只猪每次喝两桶水的混合水，如果死了，另外一只猪，验其中一桶，就可以得到结果了
     */


}