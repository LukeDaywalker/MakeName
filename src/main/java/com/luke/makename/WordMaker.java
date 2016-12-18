package com.luke.makename;

import com.luke.makename.util.DataBaseUtil;
import com.luke.makename.word.MetaLibItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivia on 2016/12/17.
 */
public class WordMaker implements Maker {
    List<MetaLibItem> itemList = new ArrayList<MetaLibItem>();

    private WordMaker() {

    }

    public static WordMaker getInstance() {
        return new WordMaker();
    }

    public void make() {
        itemList.add(new MetaLibItem(1, "土", "乙"));

        itemList.add(new MetaLibItem(3, "金", "才叉亍川寸千刃三上尸士夕小"));
        itemList.add(new MetaLibItem(3, "木", "干工弓丌及孑巾久口廿乞彡已"));
        itemList.add(new MetaLibItem(3, "水", "凡亡下子"));
        itemList.add(new MetaLibItem(3, "火", "彳大孓女勺巳乇幺弋丈"));
        itemList.add(new MetaLibItem(3, "土", "己山土丸兀丫也尢于"));

        itemList.add(new MetaLibItem(7, "金", "扱岔吵车成赤氚串吹吻伫助妆壮忖兑判七吣忍妊礽删劭佘伸身束吮私伺兕姒宋忒伭辛秀序巡酉皂卮吱孜走佐作坐"));
        itemList.add(new MetaLibItem(7, "木", "杓材岑杈床村杜呃伽改杆杠告更攻估谷庋呙囯旱何吼肓妓忌夹见角疖劫妗究局姖君佧扛囥壳克扣困伲你杞扦羌劬却杉我吴吾扤杌匣吓杏言吟杖"));
        itemList.add(new MetaLibItem(7, "水", "吧夿弝伴贝伻皀佊吡妣庇别兵伯孛吥步汊池尾汎妨彷吠吩佛否呋孚甫汞佝含罕汗亨宏囫弧汲即江戒况冷忙尨每芈妙尿妞伾屁汝汕汜忘污汐希孝形汛妤妘"));
        itemList.add(new MetaLibItem(7, "火", "犴呈辵呔甙住但低弟佃甸玎疔盯豆囤旰灸牢李利良吝伶吕卵免男呐佞弄努求忐忑町廷佟彤吞托佗妥巫妖佁佔志豸灼姊足"));
        itemList.add(new MetaLibItem(7, "土", "岙岜坂坌辰位坊坩均坎坑牡圻岐岍坍秃完圬氙岘呀岈延冶矣佚役邑吲甬攸卣佑余欤玙址"));

        itemList.add(new MetaLibItem(8, "金", "侘昌抄弨扯忱承忡初垂侏抓佌刺儿庚刮戋金侃刻孥妻戕青取叁刹姗疝尚舍社侁呻使始事受抒叔刷祀忪怂所兔昔穸些姓刖甾昃怎咋轧侄忮周妯咒宙宗卒"));
        itemList.add(new MetaLibItem(8, "木", "昂枊板杯杵竺杼东妸扼枋斧秆杲疙供咕姑孤固呱乖官果杭忽昏肌亟佶技季佳肩艽佼届卺京纠赳玖疚居咀具卷咔咖抗肯空快狂林枚杪艿呢杻杷枇其奇歧穹虬屈券枘松枉卧析呷欣芎厓兖杳宜枕枝"));
        itemList.add(new MetaLibItem(8, "水", "岸八把爸扳攽版扮姅孢卑屄沘彼畀忭抃汳汴表秉幷帛瓝沉味汶沌泛房放非氛汾忿奉扶府咐阜侅冈汩卦沆呵劾和佫呼虎或泐盲牦没妹门氓孟汨宓明命殁侔姆沐牧忸扭狃抛咆庖呸沛佩帔朋批沏汔汽沁沙沈汰汪沃武物弦冼享协忻幸汹沂雨沅咂沚状"));
        itemList.add(new MetaLibItem(8, "火", "哎佰长炒坼侈炊耷妲沓岱佽徂宕到的狄底玓典店耵定咚侗抖妒咄剁佴昉炅昊戽姐咎抉炕昆剌来佬肋例戾两冽囹呤侣仑旻奈呶妮念弩疟妾炔乳侍帑弢忝佻帖投罔昕炎佯易找争知直帙炙忠隹卓"));
        itemList.add(new MetaLibItem(8, "土", "艾坳垇委坻坫矾附矸岣岵岬坷岢坤垃峁岷坭爬帕坢坯坪坡坦坨宛往旺忤岫盱亚奄肴夜依抑佾咏呦侑於盂臾昀狁"));


        itemList.add(new MetaLibItem(15, "金", "锕钡惭惨艖掺摻婵鋋廛谄肠厂麨瞋漦瘛冲摴厨锄諔嘬疮摐噇踳锉嘱翥赐醋摧嘟锇锋敷锆刽刿铗缄剑节靓锔剧锞刳锒锂锍锊劈铺噙锓请趣髯糅锐腮毵磉傻陕殇赏审谂蚀驶奭艏熟数腧摔谁咝缌嘶驷艘螋谇琐锑铤腿鋈嘻陷缐腺哓销锌腥陉锈绪儇缊糌驵噪锃稹帜陟挚皱幢谆诼踪诹陬"));
        itemList.add(new MetaLibItem(15, "木", "葆萹箯标槽箣郴樗苇蒍著箸枞稻噔蒂腭樊葑橄稿葛赓巩穀广妫瑰郭掴荭篌糇葫槲篁蝗叽缉赍稽瘠挤稷葭价驾稼俭翦贱腱箭僵桨娇胶饺噍颉羯槿儆獍阄樛驹踞蒈慷靠颏瞌蝌课缂抠侉侩宽诳葵醌阃楼面模耦葩篇葡槭葜悭椠庆穷茕萩蝤葚枢樘葶葳妩葸瞎贤缃葙箱蝎萱样仪谊毅莹媵窳葬樟箴荮醉"));
        itemList.add(new MetaLibItem(15, "水", "鲃魃罢瘢魬褒鸨褓暴辈褙骳奔陛腷駜髲编蝙褊缏麃摽憋饼葧踣餔部漕浐蝽漘醇滴幡范鲂诽肤幞蝠驸赋腹蝜蝮澉缑盥虢憨汉撖颌褐滹浒沪哗踝逭漶辉麾慧浆漤涟凛漏漉履落玛码祃劢卖鞔满慢漫漭猫蝥貌霉魅缅缈庙缗瞑摸摩漠墨慕暮沤蒎盘醅赔霈喷嘭郫陴翩漂魄噗漆憩渗漱霆万逶嬉虾饷霄勰写兴漩演漾漪颍渔漳涨震渍"));
        itemList.add(new MetaLibItem(15, "火", "皑僾熛噌层彻踟齿憏憃除褚踔逴辍褡逮儋驻腠弹德敌骶缔踮调蝶董陡缎饵缓践进噘赉阆唠乐黎厉练谅辆嘹寮撂刘瘤搂鲁逯戮虑轮论脶熳鼐腩蝻脑闹馁辇侬驽挪噢僻热熵踏骀谈郯赕羰瑭躺铽踢缇髫抟褪驼腽辋腰瑶熠熨暂摘獐账折辄赭阵鸩征诤质觯肿缒禚辎"));
        itemList.add(new MetaLibItem(15, "土", "腤鞍璈墺嶓嶒墀磋纬诿卫慰磁嶝墩堕废坟磙嘿糊蝴峤磕蝰崂磊嶙碾嬲欧殴怄磐嵚确豌庑娴鞋糈鸦养噎叶靥亿逸影慵忧邮鱿蝣牖谀缘院阅增磔"));


        itemList.add(new MetaLibItem(17, "金", "锿嚓擦縩操艚螬懆馇锸禅偿韔鼌帱憷歜黜膗瞩聪独镀锻锷锅锾徽蹇饯键骏锴链镅镁縻鍪遣跄锹锲嚅孺鄏赛糁缫擅声谥蟀瞬锶耸锼谡虽隋缩膝蟋谿戏鲜痫猃馅谢鸺逊翼舆糟罾铡斋毡锗鍼钟诌总邹"));
        itemList.add(new MetaLibItem(17, "木", "蒡蔽檦檗蔡柽蔚赚桩苁葱蔟簇档瞪懂蔸篼擀鸽篝购媾鸹馆簋蝈馘癀桧豁击玑激哜觊艰鞯捡检謇讲蒋鲛矫阶鲒鞠鞫据飓糠颗髁恳蔻挎狯亏栏檑莲联敛蓼檩蒌篓簏蔓懋甍蔑篾茑蓬蹊谦瞧擎罄蕖阒篸蔌簌檀檄蓰辖罅芗魈蓿蔫檐荫营狱岳箦蔗栉"));
        itemList.add(new MetaLibItem(17, "水", "澳癍帮谤跸臂褾豳擘澹点淀璠繁鼢缝缚醢鼾韩憾撼嚎鸿觳浣擐璜隳浍诨阔蒗澧濂嬷缦蟒蟊弥谜糜谧摹膜浓蟠貔缥螵嫔皤璞霜濉禧霞乡鲞亵懈獬鲟澡泽澶"));
        itemList.add(new MetaLibItem(17, "火", "暧餲灿龀瞠骋丑黛担瘅烛挡蹈队鸸鲕烩绩琎爵阑痨缧儡励隶裢殓魉疗临瞵磷懔隆耧蝼璐缕螺麋缪黏咛騃燧遢蹋饧膛螳醣誊嚏瞳疃臀襄燮谣遥繇燥择辗蟑褶鸷膣螽纵"));
        itemList.add(new MetaLibItem(17, "土", "癌隘闇鮟醠遨謷闱鲔磴礅鲑壕壑磺矶礁圹岭硗嵘邬压阳嶷忆怿翳应婴膺拥优黝隅屿辕远龠郧"));


        itemList.add(new MetaLibItem(23, "金", "镳黪髑镥颥鳝铄鸶髓鼷鱚纤鹇攒脏齇鳟"));
        itemList.add(new MetaLibItem(23, "木", "欑蘩蛊鳜藿鹪惊鹫蠲兰蔹椤蓦蘖蘧癯藓鼹验驿鹬"));
        itemList.add(new MetaLibItem(23, "水", "鷩变鲼鬟禳滩"));
        itemList.add(new MetaLibItem(23, "火", "雠蛎恋鹩鳞麟轳鹭挛栾猡猱摊体显"));
        itemList.add(new MetaLibItem(23, "土", "娈岩缨"));

        itemList.add(new MetaLibItem(24, "金", "镈蚕谗谶矗鑫瓒骤"));
        itemList.add(new MetaLibItem(24, "木", "霭簖赣羁搅蓠篱酿衢龋魇鹰攥"));
        itemList.add(new MetaLibItem(24, "水", "蚌髌鬓霍辔颦躞"));
        itemList.add(new MetaLibItem(24, "火", "螭鞑癫蠹攫谰鳢雳灵陇让闼瘫龌鳣"));
        itemList.add(new MetaLibItem(24, "土", "坝罐盐艳呓"));

        DataBaseUtil.saveWordList(itemList);
    }
}
