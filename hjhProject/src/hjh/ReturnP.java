package hjh;

import java.util.*;

public class ReturnP {

	Scanner sc = new Scanner(System.in);
	ReturnDAO dao= new ReturnDAO();

	public void system() {
		boolean run = true;
		while(run) {
			System.out.println("1.대출\t2.반납\t3.돌아가기");
			System.out.print("선택>>");
			int ch = Integer.parseInt(sc.nextLine());
			
			switch(ch){
				case 1 : 
					System.out.print("회원번호>> ");
					int mNo  = Integer.parseInt(sc.nextLine());
				
					System.out.print("대출할 도서번호>> ");
					int bNo  = Integer.parseInt(sc.nextLine());
					
					RentBook bbook = new RentBook();
					bbook.setMemNo(mNo);
					bbook.setBookNo(bNo);
					if(dao.rentBook(bbook)) {
						System.out.println("대출완료");
					}else {System.out.println("대출실패");
					}
					
					break; 
				case 2 : 
					System.out.print("회원번호>> ");
					int mName2  = Integer.parseInt(sc.nextLine());
					System.out.print("반납할 도서번호>> ");
					int bName2  = Integer.parseInt(sc.nextLine());
					bbook = new RentBook();
					bbook.setMemNo(mName2);
					bbook.setBookNo(bName2);
					if(dao.returnBook(bbook)) {
						System.out.println("반납완료");
					}else {System.out.println("반납실패");
					}
				
					break;
					
				case 3 : 
					run = false;
					break;
			}
		}
	}
}
