package leetcodeTraining;

/*
 * 未通过
 */
public class RectangleArea_223 {
	
	public static void main(String[] args){
		RectangleArea_223 ra = new RectangleArea_223();
		int area = ra.computeArea(0, 0, 0, 0, -1, -1, 1, 1);
		System.out.println(area);
	}
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A==B && B==C && C==D ) {
			if (A>C){
				int max_x = A;
				int min_x = C;
			}else{
				int max_x = C;
				int min_x = A;
			}
			if (B>D){
				int max_y = B;
				int min_y = D;
			}else{
				int max_y = D;
				int min_y = B;
			}
        	return Math.abs((A-C)*(B-D));
		}else if( E==F && E==G && G==H){
			if (E>G){
				int max_x = E;
				int min_x = G;
			}else{
				int max_x = G;
				int min_x = E;
			}
			if (F>H){
				int max_y = F;
				int min_y = H;
			}else{
				int max_y = H;
				int min_y = F;
			}
        	return Math.abs((A-C)*(B-D));
		}else if (B > H || D < F || A > G || C < E){            
        	return 0;
        }else{
            int left_x = (A>E)?A:E;
            int left_y = (B>F)?B:F;
            int right_x = (C<G)?C:G;
            int right_y = (D<H)?D:H;
            int totalArea = Math.abs((right_x-left_x)*(right_y-left_y));
            return totalArea;
        }
    }

}
