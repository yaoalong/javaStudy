package org.xhome.enumPackage;

public class EnumTest {
	
	public enum ColorEnum{
		red,green,yellow,blud;
	}
	
	public enum SeasonEnum{
		
		spring,summer,autumn,winter;
		
		private final static String position="test";
		
		public static SeasonEnum getSeason(){
			if("test".endsWith(position)){
				return spring;
			}
			else{
				return winter;
			}
		}
	}
	public enum Gender{
		MAN("男人"),WOMEN("女人");
		private  final String value;
		Gender(String value){
			this.value=value;
		}
		public String getValue(){
			return value;
		}
	}
	public static void main(String args[]){
		System.out.println("Quick ======");
		System.out.println("季节为:"+SeasonEnum.getSeason());
		
		ColorEnum colorEnum=ColorEnum.blud;
		switch(colorEnum){
		case blud:
			System.out.println("color is blue");
			break;
		default:
			System.out.println("color is others");
		}
		System.out.println("ColorEnum 枚举的值有"+ColorEnum.values().length);
		System.out.println("++++++++++++");
		for(Gender gender:Gender.values()){
			System.out.println(gender.value);
		}
		System.out.println("===================");
		Gender gender=Gender.MAN;
		System.out.println(gender.getValue());
		
	}
}
