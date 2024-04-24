package hjh;

import java.util.*;

//import co.yedam.Member;

public class BookManager {

	BookDAO dao = new BookDAO();
	Scanner sc = new Scanner(System.in);

	public void exe() {

		boolean run = true;
		while (run) {
			System.out.println(" 1.도서목록 2.전체도서관리 3.대출도서현황 4.회원관리 5.종료");
			System.out.print("선택>>");
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
				System.out.println("대출도서현황");

				List<RentBook> list = dao.returnlist();
				System.out.println("도서번호	 도서제목	  	저자	  대출여부	회원이름      대출날짜  반납기한일");
				System.out.println("-------------------------------------------------------------------------");
				for (RentBook rent : list) {
					System.out.println(rent.toString());
				}
				break;

			case 4: // 4.회원관리
				manageMember();

				break;
			case 5:
				System.out.println("프로그램 종료");
				run = false;
			}

		} // end of while.

	} // end of exe.

	void bookList() {
		SearchVO search = new SearchVO();
		List<Book> book = dao.bookList(search);
		System.out.println("도서번호	 도서제목	  	저자		구매일 		 	가격");
		System.out.println("------------------------------------------------------------------------");
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

			System.out.println("1.도서번호검색 2.제목검색 3.저자검색 4.돌아가기");
			System.out.print("선택>>");
			int ch2 = sc.nextInt();
			sc.nextLine();

			switch (ch2) {
			case 1:
				System.out.print("도서번호를 입력하세요> ");
				search.setBookNo(sc.nextLine());
				break;
			case 2:
				System.out.print("도서제목를 입력하세요> ");
				search.setTitle(sc.nextLine());
				break;

			case 3:
				System.out.print("저자를 입력하세요> ");
				search.setAuthor(sc.nextLine());
				break;

			case 4:
				run2 = false;
				return;
			}

			List<Book> book1 = dao.bookList(search);

			System.out.println("도서번호	 도서제목	  	저자		구매일 		 	가격");
			System.out.println("------------------------------------------------------------------------");

			for (Book bk1 : book1) {
				System.out.println(bk1.toString());
			}
		}
	} // end of searchBook.

	void bookManage() {
		boolean run3 = true;
		while (run3) {
			UpdateVO update = new UpdateVO();
			
			System.out.println(" 1.도서신규등록 2.도서정보수정 3.도서삭제 4.돌아가기");
			System.out.println("선택>> ");
			int ch3 = sc.nextInt();
			sc.nextLine();

		switch (ch3) {
		case 1:
			System.out.print("- 도서 신규 등록");
			System.out.println("도서명> ");
			String ti = sc.nextLine();

			System.out.println("구매일자> ");
			String bu = sc.nextLine();

			System.out.println("저자> ");
			String au = sc.nextLine();

			System.out.println("가격> ");
			String pr = sc.nextLine();
		
			
			update.setTitle(ti);
			update.setBuyDate(bu);
			update.setAuthor(au);
			update.setPrice(pr);
			
			if(dao.insertBook(update)) {
				System.out.println("정상 등록");
			}else {
				System.out.println("등록 실패");
			}
//			break;
			
		case 2:
			System.out.print("저자명> ");
			update.setTitle(sc.nextLine());
			break;

		case 3:
			System.out.print("저자를 입력하세요> ");
			update.setAuthor(sc.nextLine());
			break;

		case 4:
			run3 = false;
			return;
		}
	
		}
		
	}

	void manageMember() {
		List<Member> mem = dao.memberList();
		System.out.println("회원번호	회원명 회원연락처 대출도서번호 ");
		System.out.println("------------------------------------------------");
		for (Member mm : mem) {
			System.out.println(mm.toString());
		}
		System.out.println();
	}

} // end of class.
