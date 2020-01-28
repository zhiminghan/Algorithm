package com.algorithm.dynamic;

public class KnapsackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] w = {2, 3, 4};//物品的重量
		String[] names={"吉他","音响","电脑"};
		int[] val = {1500, 3000, 10000}; //物品的价值 这里val[i] 就是前面讲的v[i]
		int m = 4; //背包的容量
		int n = val.length; //物品的个数
		System.out.println(maxValue(w,val,m));
		int []goods={-1,-1,-1};
		//创建二维数组，
		//[表情][i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
		int[][] v = new int[n+1][m+1];
		//为了记录放入商品的情况，我们定一个二维数组
		int[][] path = new int[n+1][m+1];
		int maxVal=0;	
		//初始化第一行和第一列, 这里在本程序中，可以不去处理，因为默认就是0
		for(int i = 0; i < v.length; i++) {
			v[i][0] = 0; //将第一列设置为0
		}
		for(int i=0; i < v[0].length; i++) {
			v[0][i] = 0; //将第一行设置0
		}
		
		
		//根据前面得到公式来动态规划处理
		for(int i = 1; i < v.length; i++) { //不处理第一行 i是从1开始的
			for(int j=1; j < v[0].length; j++) {//不处理第一列, j是从1开始的
				//公式
				if(w[i-1]> j) { // 因为我们程序i 是从1开始的，因此原来公式中的 w[i] 修改成 w[i-1]
					v[i][j]=v[i-1][j];
				} else {
					//说明:
					//因为我们的i 从1开始的， 因此公式需要调整成
					//[表情][i][j]=Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);
					//[表情][i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
					//为了记录商品存放到背包的情况，我们不能直接的使用上面的公式，需要使用if-else来体现公式
					if(v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
						v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
						//把当前的情况记录到path
						path[i][j] = 1;
						goods[i-1]=i-1;
						maxVal=v[i][j];
					} else {
						v[i][j] = v[i - 1][j];
					}
					
				}
			}
		}
		
		//输出一下v 看看目前的情况
		for(int i =0; i < v.length;i++) {
			for(int j = 0; j < v[i].length;j++) {
				System.out.printf("%d\t",v[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("============================");
		//输出最后我们是放入的哪些商品
		//遍历path, 这样输出会把所有的放入情况都得到, 其实我们只需要最后的放入
//		for(int i = 0; i < path.length; i++) {
//			for(int j=0; j < path[i].length; j++) {
//				if(path[i][j] == 1) {
//					System.out.printf("第%d个商品放入到背包\n", i);
//				}
//			}
//		}
		for (int i = 0; i < goods.length; i++) {
			if(goods[i]!=-1){
				System.out.printf("把%s放入到背包\n", names[i]); 
			}
		}
		System.out.printf("容量为%d的背包，最大价值为%d\n",m,maxVal); 
		//动脑筋
//		int i = path.length - 1; //行的最大下标
//		int j = path[0].length - 1;  //列的最大下标
//		while(i > 0 && j > 0 ) { //从path的最后开始找
//			if(path[i][j] == 1) {
//				System.out.printf("第%d个商品放入到背包\n", i); 
//				j -= w[i-1]; //w[i-1]
//			}
//			i--;
//		}
		
	}

	public static int maxValue(int[]weight,int[]price,int cap){

		int[][] dp=new int[weight.length+1][cap+1];

		for(int i=0;i<dp.length;i++){
			dp[i][0]=0;
		}

		for(int j=0;j<dp[0].length;j++){
			dp[0][j]=0;
		}

		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){

				if(j>=weight[i-1]){
					dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+price[i-1]);

				}else{
					dp[i][j]=dp[i-1][j];

				}
			}
		}

		return dp[weight.length][cap];

	}

}