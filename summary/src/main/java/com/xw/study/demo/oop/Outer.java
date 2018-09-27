package com.xw.study.demo.oop;
//
//public class Outer {
//	private String oname = "张三";
//	private Integer oage = 18;
//	private String name = "LISA";
//	class Inner {
//		private String name = "李四";
//		private Integer age = 20;
//		public void test01() {
//			System.out.println(oname);// 张三
//			System.out.println(oage);// 18
//			System.out.println(name);// 李四
//			System.out.println(age);// 20
//			System.out.println(Outer.this.name);
//		}
//	}
////	public static void main(String[] args) {
////		Outer outer = new Outer();
////		Outer.Inner inner = outer.new Inner();
////		inner.test01();
////	}
//	public static void main(String[] args) {
//		
//		System.out.println(1.0/100);
//	}
//}



public class Outer{
	
	private String name = "张三";
	private Integer age = 18;
	
	private void test01() {
		
		class Inner{
			private void test02() {
				System.out.println(name);
			}
		}
	}

}
