package hjh;

import java.util.*;

public class ReturnP {

	Scanner sc = new Scanner(System.in);
	ReturnDAO dao= new ReturnDAO();
	public void system() {
		boolean run = true;
		while(run) {
			System.out.println();
			System.out.println("\t1.대출\t2.반납\t3.돌아가기");
			System.out.print("\t선택>> ");
			int ch = 0;
			
			try {
				ch = Integer.parseInt(sc.nextLine());

			}catch (Exception e) {
				ch = 6;
			}
			switch(ch){
				case 1 : 
					System.out.print("\t회원번호>> ");
					int mNo  = Integer.parseInt(sc.nextLine());
				
					System.out.print("\t대출할 도서번호>> ");
					int bNo  = Integer.parseInt(sc.nextLine());
				RentBook bbook = new RentBook();
					bbook.setMemNo(mNo);
					bbook.setBookNo(bNo);
					if(dao.rentBook(bbook)) {
						BookManager.clearScreen();
						System.out.println("\t**********대출 완료***********");
					}else {
						BookManager.clearScreen();
						System.out.println("\t**************대출 실패************");
					}
					
					break; 
				case 2 : 
					System.out.print("\t회원번호>> ");
					int mName2  = Integer.parseInt(sc.nextLine());
					System.out.print("\t반납할 도서번호>> ");
					int bName2  = Integer.parseInt(sc.nextLine());
					bbook = new RentBook();
					bbook.setMemNo(mName2);
					bbook.setBookNo(bName2);
					if(dao.returnBook(bbook)) {
						
						BookManager.clearScreen();
						System.out.println("\t**********반납 완료***********");
					}else {
						BookManager.clearScreen();
						System.out.println("\t**********반납 실패***********");
					}
				
					break;
					
				case 3 : 
					run = false;
					break;
				default : 
					System.out.println("\t오류! 1~3까지의 숫자를 입력하세요");
					break;
			}
		}
	}
}
