package array;

/**
 * Created by cdyujing7 on 2018/8/12.
 */
public class FindSameLinePointsInArray {

    public static int findSameLinePointsInArray(Point[] points) {
        if(points == null){
            return 0;
        }
        if(points.length <= 2){
            return points.length;
        }
        int max = 2;
        for(int i=0;i<points.length-1;i++){
            int same = 0;
            for(int j=i+1;j<points.length;j++){
                int count = 1;
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    same++;
                } else {
                    count++;
                    for(int k=j+1;k<points.length;k++){
                        if((points[j].y-points[i].y)*(points[i].x-points[k].x) == (points[k].y-points[i].y)*(points[i].x-points[j].x)){
                            count++;
                        }
                    }
                }
                max = max > same + count ? max : same + count;
            }
        }
        return max;

    }

}
