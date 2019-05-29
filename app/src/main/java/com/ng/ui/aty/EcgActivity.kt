package com.ng.ui.aty

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ng.ui.R
import com.ng.ui.view.EcgShowViewJava
import com.ng.ui.view.EcgShowViewJava.SHOW_MODEL_DYNAMIC_REFRESH
import java.util.*

class EcgActivity : AppCompatActivity() {
    private lateinit var ecgview: EcgShowViewJava

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecg)
        ecgview = findViewById(R.id.ecgview);
        health_data1 = health_data1 + health_data1 + health_data1 + health_data1 + health_data1 + health_data1

        //显示全部心电图
        //ecgview.setData(health_data1,EcgShowViewJava.SHOW_MODEL_ALL)


        //显示滚动心电动态图
        //ecgview.setData(health_data1,EcgShowViewJava.SHOW_MODEL_DYNAMIC_SCROLL)

        //动态显示心电数据
        showEcgData()

    }

    private lateinit var timer: Timer
    private lateinit var timerTask: TimerTask
    private lateinit var dataList: Array<String>
    private var index: Int = 0

    private fun showEcgData() {
        ecgview.setData(null, SHOW_MODEL_DYNAMIC_REFRESH)

        dataList = health_data1.split(",").toTypedArray()
        timer = object : Timer() {}

        timerTask = object : TimerTask() {
            override fun run() {
                if (index >= dataList.size) {
                    index = 0
                }
                if (dataList[index] == null || dataList[index] == "") return
                ecgview.showLine(dataList[index].toFloat())
                index++
            }
        }
        timer.schedule(timerTask, 500, 50)
    }

    private var health_data1 = "0.101253886148333549,0.0" +
            "01253886148333549,0.003036087844520807,0.002440808573737741,-0.01077798567712307,-0.02941250056028366,-0.02127" +
            "940207719803,0.03379339724779129,0.09094017744064331,0.05208359658718109,-0.1133501008152962,-0.2622079849243" +
            "164,-0.1582041531801224,0.2832704782485962,0.8482071161270142,1.202911853790283,1.217478036880493,1.0064306259" +
            "15527,0.5614029765129089,-0.5808430314064026,-3.093567848205566,-7.158360481262207,-12.06765747070312,-16.67280" +
            "197143555,-20.29765510559082,-23.17350387573242,-25.97895050048828,-29.04569435119629,-32.08361053466797,-34.611" +
            "01150512695,-36.49107360839844,-37.83483505249023,-39.2723503112793,-40.31753540039062,-41.73135375976562,-44.40" +
            "776443481445,-48.18602752685547,-50.971923828125,-49.85507965087891,-44.25748062133789,-38.60691070556641,-40.88" +
            "425827026367,-55.82911682128906,-75.75099182128906,-75.57111358642578,-20.18935394287109,112.4039306640625,302.4" +
            "443969726562,478.810302734375,549.542724609375,462.8594360351562,253.620361328125,29.86661911010742,-99.094490" +
            "05126953,-97.12584686279297,-16.40250968933105,55.83222579956055,67.73938751220703,30.61519622802734,-9.7101583" +
            "48083496,-20.65663146972656,-5.159292697906494,12.56078052520752,15.47367382049561,5.182388305664062,-4.5807843" +
            "20831299,-4.939818382263184,1.16289758682251,5.320072650909424,3.525331497192383,-0.9494332075119019,-2.7819726" +
            "46713257,-0.7593205571174622,1.852165102958679,1.934446334838867,-0.02557146549224854,-1.326619863510132,-0.662" +
            "1173620223999,0.7012819647789001,1.002269268035889,0.1525551378726959,-0.5706530809402466,-0.3565154075622559," +
            "0.3104846179485321,0.5506284832954407,0.2197907865047455,-0.1195622012019157,-0.04902923107147217,0.2566174864" +
            "768982,0.403188943862915,0.3047243356704712,0.1968544721603394,0.2810082137584686,0.5909113883972168,0.5504930" +
            "019378662,0.9481502175331116,0.3396361768245697,-0.9867785573005676,-1.6379554271698,0.3059036731719971,4.8029" +
            "6802520752,7.988834857940674,4.358085632324219,-7.128910541534424,-18.30419731140137,-13.80635738372803,19.7751" +
            "1596679688,82.21820831298828,152.1483306884766,190.4971923828125,159.1590728759766,49.01980972290039,-102.2764" +
            "30415726,0.07632210850715637,0.04921660572290421,0.02271043695509434,"
}
