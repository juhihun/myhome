package hjh;

import java.util.List;
import java.util.Scanner;

//import co.yedam.Member;

public class BookManager {

		
	BookDAO dao = new BookDAO();
	Scanner sc = new Scanner(System.in);
	MemDAO mdao = new MemDAO();
	ReturnDAO rdao = new ReturnDAO();
	public void exe() {

		boolean run = true;
		while (run) {
			System.out.println("========================================================================================");
			System.out.println(" 1.도서목록\t2.전체도서관리\t3.대출도서현황\t4.회원관리\t5.대출,반납\t6.종료");
			System.out.println("========================================================================================");
			System.out.print("- 번호입력 : ");
			int ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 1: // 1.도서목록
				bookList();
				break;

			case 2: // 2.전체도서관리
				bookManage();
				break;

			case 3: // 3.대출도서현황
				System.out.println("○ 대출도서현황");

				List<RentBook> list = rdao.returnlist();
				System.out.println("\t도서번호\t\t도서제목\t\t 저자\t  대출여부       회원이름\t\t대출날짜\t\t\t반납기한일");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------");
				for (RentBook rent : list) {
					System.out.println(rent.toString());
				}
				break;
			case 4: // 4.회원관리
				manageMember();
				break;
			
			case 5: 
			
				System.out.println("○ 대출도서현황");
				ReturnP returnp = new ReturnP();
				returnp.system();
				
				break;

			case 6:
				System.out.println("프로그램 종료");
				run = false;
			}

		} // end of while.

	} // end of exe.

	void bookList() {
		SearchVO search = new SearchVO();
		List<Book> book = dao.bookList(search);
		
		System.out.println("\t도서번호\t\t도서제목\t\t  저자\t\t구매일\t\t\t\t가격");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (Book bk : book) {
			System.out.println(bk.toString());
		}
		
		System.out.println();
		searchBook();
	}

	void searchBook() {
		boolean run2 = true;
		while (run2) {
			SearchVO search = new SearchVO();

			System.out.println("\t<세부선택>");
			System.out.println("\t1.도서번호검색\t2.제목검색\t3.저자검색\t4.돌아가기");
			System.out.print("\t선택>>");
			
			int ch2 = sc.nextInt();
			sc.nextLine();

			switch (ch2) {
			case 1:
				System.out.print("\t도서번호를 입력하세요> ");
				search.setBookNo(sc.nextLine());
				break;
			case 2:
				System.out.print("\t도서제목를 입력하세요> ");
				search.setTitle(sc.nextLine());
				break;

			case 3:
				System.out.print("\t저자를 입력하세요> ");
				search.setAuthor(sc.nextLine());
				break;

			case 4:
				run2 = false;
				return;
			}

			List<Book> book1 = dao.bookList(search);

			System.out.println("\t도서번호\t\t도서제목\t\t  저자\t\t구매일\t\t\t\t가격");
			System.out.println("\t---------------------------------------------------------------------------------------------------");

			for (Book bk1 : book1) {
				System.out.println(bk1.toString());
			}
		}
	} // end of searchBook.

	void bookManage() {
		boolean run3 = true;
		while (run3) {
			UpdateVO update = new UpdateVO();

			System.out.println("1.도서신규등록\t2.도서정보수정\t3.도서삭제\t4.돌아가기");
			System.out.print("선택>>\t");
			int ch3 = sc.nextInt();
			sc.nextLine();
			switch (ch3) {
			case 1:
				System.out.println("○ 도서 신규 등록");
				System.out.print("도서명> ");
				String ti = sc.nextLine();

				System.out.print("구매일자> ");
				String bu = sc.nextLine();

				System.out.print("저자> ");
				String au = sc.nextLine();

				System.out.print("가격> ");
				String pr = sc.nextLine();


				update.setTitle(ti);
				update.setBuyDate(bu);
				update.setAuthor(au);
				update.setPrice(pr);

				if (dao.insertBook(update)) {
					System.out.println("정상 등록");
				} else {
					System.out.println("등록 실패");
				}
				break;

			case 2:
				System.out.println("○ 도서 정보 수정");
				System.out.print("수정할 도서번호> ");
				int no1 = Integer.parseInt(sc.nextLine());

				System.out.print("도서제목> ");
				String ti1 = sc.nextLine();

				System.out.print("저자> ");
				String au1 = sc.nextLine();

				System.out.print("구매일> ");
				String bu1 = sc.nextLine();

				System.out.print("가격> ");
				String pr1 = sc.nextLine();

				update.setBookNo(no1);
				update.setTitle(ti1);
				update.setAuthor(au1);
				update.setBuyDate(bu1);
				update.setPrice(pr1);

				if (dao.updateBook(update)) {
					System.out.println("수정 성공");
				} else {
					System.out.println("수정 실패");
				}
				break;

			case 3:
				System.out.println("○ 도서 정보 삭제");
				System.out.print("삭제할 도서번호> ");
				int no2 = Integer.parseInt(sc.nextLine());

				update.setBookNo(no2);

				if (dao.deleteBook(update)) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				}
				break;

			case 4:
				run3 = false;
				return;
			}
		}

	}

	void manageMember() {
		boolean run3 = true;
		while (run3) {
			System.out.println("1.회원목록 2.회원등록 3.회원정보수정 4.회원삭제 5.돌아가기");
			System.out.print("선택>> ");
			int ch3 = sc.nextInt();
			sc.nextLine();
			
			switch (ch3) {
			case 1 :
				List<Member> list = mdao.memberList();
				System.out.println("\t회원번호\t  회원명\t\t   회원연락처\t대여권수");
				System.out.println("---------------------------------------------------------");
				for (Member mm : list) {
					System.out.println(mm.toString());
				}
				System.out.println();
				break;
			case 2:
				System.out.println("○ 회원 신규 등록");
				System.out.print("회원명> ");
				String name = sc.nextLine();

				System.out.print("회원 연락처> ");
				String ph = sc.nextLine();

				Member member = new Member();
				
				member.setName(name);
				member.setNumber(ph);

	
				if (mdao.InsertMem(member)) {
					System.out.println("정상 등록");
				} else {
					System.out.println("등록 실패");
				}
				break;

			case 3:
				System.out.println("○ 회원 정보 수정");
				System.out.print("수정할 회원번호> ");
				int no1 = Integer.parseInt(sc.nextLine());

				System.out.print("회원이름> ");
				String name1 = sc.nextLine();

				System.out.print("회원 연락처> ");
				String num = sc.nextLine();

				member = new Member();
				member.setMemNo(no1);
				member.setName(name1);
				member.setNumber(num);

				if (mdao.updateMember(member)) {
					System.out.println("수정 성공");
				} else {
					System.out.println("수정 실패");
				}
				break;

			case 4:
				System.out.println("○ 회원 정보 삭제");
				System.out.print("삭제할 회원번호> ");
				int no2 = Integer.parseInt(sc.nextLine());
				
				member = new Member();
				member.setMemNo(no2);

				if (mdao.deleteMember(member)) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 5:
				run3 = false;
				return;
			}
		}
	}

	
} // end of class.
