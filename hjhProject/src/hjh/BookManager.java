package hjh;

import java.util.*;

public class BookManager {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	DAO dao = new DAO();
	
	System.out.println(" 1.도서목록 2.도서등록 3.도서정보수정 4.대출도서관리 5.회원관리 6.종료");	
	System.out.print("선택>>");
	int ch = sc.nextInt();
	sc.nextLine();
	
	boolean run = true;
	while(run) {
	 switch(ch) {
	 case 1 : 
		 List<Book> book = dao.bookList();
		 System.out.println("도서번호	 도서제목	  	저자		구매일 		 	가격");	
		 System.out.println("------------------------------------------------------------------------");
		 for(Book bk : book) {
			 System.out.println(bk.toString());
		 }
		 System.out.println("1.제목검색 2.도서번호검색 3.저자검색 4.돌아가기");
		 System.out.print("선택>>");
		 int ch2 = sc.nextInt();
		 sc.nextLine();
		 break;
		 
	 case 2 : 
		 System.out.println("도서명> ");
		 String ti = sc.nextLine();
		 
		 System.out.println("구매일자> ");
		 String bu = sc.nextLine();
		 
		 System.out.println("저자> ");
		 String au = sc.nextLine();
		 
		 System.out.println("가격> ");
		 String pr = sc.nextLine();
		 
		 Book bk= new Book();
		 bk.setTitle(ti);
		 bk.setBuydate(bu);
		 bk.setAuthor(au);
		 bk.setPrice(pr);
		 
		 if(dao.insertBook(bk)) {
			 System.out.println("정상등록");
		 }else {
			 System.out.println("예외발생");
		 }break;
		 
		 
	 case 3 : 
		 System.out.print("수정할 도서 번호> ");
		 int up = Integer.parseInt(sc.nextLine());
		 System.out.print("도서제목 > ");
		 ti = sc.nextLine();
		 
		 System.out.print("저자 > ");
		 au = sc.nextLine();
		 
		 System.out.print("가격 > ");
		 pr = sc.nextLine();
		 
		 bk = new Book();
		 bk.setTitle(ti);
		 bk.setAuthor(au);
		 bk.setPrice(pr);
		 
		 if(dao.updateBook(bk)) {
			 System.out.println("수정완료");
		 }else {
			 System.out.println("처리실패");
		 }
		 break;
	 
	 case 4 : 
	 case 5 : 
	 case 6 : 
	 }
	break;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
