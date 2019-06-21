package com.application.algorithm.lcss;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vividsolutions.jts.geom.Coordinate;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TrajectoryLCSS {

    private Coordinate[] L1;
    private Coordinate[] L2;
    private Coordinate[] LCS;
    private double distThre;
    private double matchRatio;
    private static final double DEFAULT_DISTTHRE = 0.0005;//经纬度差值阈值大约0.001在地图上相差80-90米
    private int commonLen;

    public TrajectoryLCSS(Coordinate[] L1,Coordinate[] L2) {
        this.L1=L1;
        this.L2=L2;
        this.distThre=DEFAULT_DISTTHRE;
    }
    /**
     * @param L1
     * @param L2
     * @param dist_thre
     */
    public TrajectoryLCSS(Coordinate[] L1,Coordinate[] L2,double dist_thre) {
        this(L1, L2);
        this.distThre=dist_thre;
    }
    /**
     * 动态规划计算所有子问题
     * @return
     */
    public int[][] getTypeMatrix(){
        int[][] type=new int[L1.length+1][L2.length+1];
        for(int i=L1.length-1;i>=0;i--) {
            for(int j=L2.length-1;j>=0;j--) {
                if(isClose(L1[i],L2[j])){
//                    System.out.println(L1[i]);
//                    System.out.println(L2[j]);
                    type[i][j]=type[i+1][j+1]+1;
                    commonLen++;
                }else {
                    type[i][j]=Math.max(type[i][j+1], type[i+1][j]);
                }
            }
        }
        return type;
    }
    /**
     * 查看两点是否可以判定为同点
     * @param p1
     * @param p2
     * @return
     */
    public boolean isClose(Coordinate p1,Coordinate p2) {
        double x_abs=Math.abs(p1.x-p2.x);
        double y_abs=Math.abs(p1.y-p2.y);
        if(x_abs<distThre&&y_abs<distThre)
            return true;
        return false;
    }
    /**
     * @return
     */
    public Coordinate[] genLCSS() {
        int[][] typematrix=getTypeMatrix();
        Coordinate[] res = new Coordinate[commonLen];
        int i=0,j=0;
        int index=0;
        while(i<L1.length&&j<L2.length) {
            if(isClose(L1[i],L2[j])) {
                System.out.println(index);
                System.out.println(i);
                System.out.println(commonLen);
                System.out.println(L1[i]);
                System.out.println(L2[j]);
                res[index++]=L1[i];
                i++;
                j++;
            }else if(typematrix[i+1][j]>=typematrix[i][j+1]) {
                i++;
            }else {
                j++;
            }
        }
        LCS=res;
        matchRatio=this.LCS.length/(double)(Math.min(L1.length,L2.length));
        return res;
    }
    /**
     * 更新Ratio
     * @return
     */
    public double getMatchRatio() {
        if(matchRatio==0) {
            genLCSS();
        }
        return this.LCS.length/(double)(Math.min(L1.length,L2.length));
    }

    public static void main(String[] args) {
//        Coordinate[] coor1=new Coordinate[5];
//        coor1[0]=new Coordinate(114.300, 30.1);
//        coor1[1]=new Coordinate(114.302, 30.101);
//        coor1[2]=new Coordinate(114.3023, 30.1002);
//        coor1[3]=new Coordinate(114.30235, 30.1011);
//        coor1[4]=new Coordinate(114.304, 30.1003);
//        Coordinate[] coor2=new Coordinate[2];
//        coor2[0]=new Coordinate(114.301, 30.1002);
//        coor2[1]=new Coordinate(114.3023, 30.1015);
//        TrajectoryLCSS lcss=new TrajectoryLCSS(coor1, coor2, 0.001);
//        Coordinate[] coors = lcss.genLCSS();
//        System.out.println(lcss.getMatchRatio());


        StringBuilder sb1 = new StringBuilder();
        sb1.append("[{\"longitude\":119.049659729,\"latitude\":24.884826660158},\n" +
                " {\"longitude\":119.06888580322,\"latitude\":24.820281982423},\n" +
                " {\"longitude\":118.95902252197,\"latitude\":24.788696289064},\n" +
                " {\"longitude\":119.0057144165,\"latitude\":24.707672119142},\n" +
                " {\"longitude\":118.89585113525,\"latitude\":24.682952880861},\n" +
                " {\"longitude\":118.96588897705,\"latitude\":24.629394531251},\n" +
                " {\"longitude\":118.89722442627,\"latitude\":24.611541748048},\n" +
                " {\"longitude\":118.84984588624,\"latitude\":24.592315673829}]");
        //readFileByChars("D:\\tomcat\\apache-tomcat-8.5.39\\webapps\\test\\temp_ships_trajectory_dilution1.json",sb1);
        //readFileByChars("D:\\tomcat\\apache-tomcat-8.5.39\\webapps\\test\\keyAreaData1.json",sb1);
        JSONArray jsonArray1 = JSONArray.parseArray(sb1.toString());
        Coordinate[] coor1  = new Coordinate[jsonArray1.size()];;
        for(int i = 0; i< jsonArray1.size();i++){
            JSONObject jsonObject = (JSONObject) jsonArray1.get(i);
            coor1[i] = new Coordinate(jsonObject.getDouble("longitude"),jsonObject.getDouble("latitude"));
        }

        StringBuilder sb2 = new StringBuilder();
        sb2.append("[{\"longitude\":119.13755035401,\"latitude\":24.882080078125},\n" +
                " {\"longitude\":119.136177063,\"latitude\":24.880706787109},\n" +
                " {\"longitude\":119.15677642823,\"latitude\":24.816848754883},\n" +
                " {\"longitude\":119.08811187745,\"latitude\":24.774276733398},\n" +
                " {\"longitude\":119.136177063,\"latitude\":24.698745727539},\n" +
                " {\"longitude\":119.05927276612,\"latitude\":24.676773071289},\n" +
                " {\"longitude\":119.11969757081,\"latitude\":24.621841430664},\n" +
                " {\"longitude\":118.9864883423,\"latitude\":24.580642700195},\n" +
                " {\"longitude\":118.98923492433,\"latitude\":24.580642700195},\n" +
                " {\"longitude\":118.99884796144,\"latitude\":24.590255737305},\n" +
                " {\"longitude\":118.9961013794,\"latitude\":24.584762573242}]");
        //readFileByChars("D:\\tomcat\\apache-tomcat-8.5.39\\webapps\\test\\keyAreaData2.json",sb2);
        //readFileByChars("D:\\tomcat\\apache-tomcat-8.5.39\\webapps\\test\\json.json",sb2);
        JSONArray jsonArray2 = JSONArray.parseArray(sb2.toString());
        Coordinate[] coor2  = new Coordinate[jsonArray2.size()];;
        for(int i = 0; i< jsonArray2.size();i++){
            JSONObject jsonObject = (JSONObject) jsonArray2.get(i);
            coor2[i] = new Coordinate(jsonObject.getDouble("longitude"),jsonObject.getDouble("latitude"));
        }

        TrajectoryLCSS lcss=new TrajectoryLCSS(coor1, coor2, 0.001);
        Coordinate[] coors = lcss.genLCSS();
        System.out.println(lcss.getMatchRatio());

    }

    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static void readFileByChars(String fileName,StringBuilder stringBuilder) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            //System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    stringBuilder.append((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
