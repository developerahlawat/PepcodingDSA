package com.pepcoding.dsa;

public class BuySellStocks {

	public static void main(String [] args) {
		int price[] = { 20,10,20,30,40,50,80,10,90 };
	   findMaxProfitDays(price);
	}
		 
		private static void findMaxProfitDays(int[] prices) {
			int buy=0;
			int sell=1;
			int profit=0;
			int sum=0;
			
			while(sell<prices.length && buy<prices.length) {
				
				if(prices[buy]< prices[sell]) {
					System.out.println("inside first if");
					sell++;
				} else if(prices[buy]> prices[sell]) {
					if(sell-buy>=1) {
						System.out.println("inside if");
						profit=prices[sell-1]-prices[buy];
					    sum+=profit;
					   
					    print(buy, sell, sum);
					    
					    profit=0;
					    buy=sell;
					    sell++;
					} 
					else {
						buy++;
						sell++;
					}
				}
			}
		
		profit=prices[sell-1]-prices[buy];
		sum+=profit;
		print(buy, sell, sum);
		}

		private static void print(int buy, int sell, int sum) {
			System.out.println("purchase at day");
			System.out.println(buy);
			System.out.println("sell at day");
			System.out.println(sell);
			System.out.println("profit");
			System.out.println(sum);
		}
	}
	
