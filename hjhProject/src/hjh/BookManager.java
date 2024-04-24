package hjh;

import java.util.*;

public class BookManager {

	BookDAO dao = new BookDAO();
	Scanner sc = new Scanner(System.in);
	
	public void exe() {

		boolean run = true;
		while (run) {
			System.out.println(" 1.도서목록 2.전체도서관리 3.대출도서관리 4.회원관리 5.종료");
			System.out.print("선택>>");
			int ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 1: // 1.도서목록
				bookList();
				break;
		
			case 2: // 2.전체도서관리
				System.out.println(" 1.도서신규등록 2.도서정보수정 3.도서삭제 4.돌아가기");
				int ch2 = sc.nextInt();
				bookManage();
				break;

			case 3: // 3.대출도서관리
				System.out.print("수정할 도서 번호> ");
				int up = Integer.parseInt(sc.nextLine());
				System.out.print("도서제목 > ");
				String ti = sc.nextLine();

				System.out.print("저자 > ");
				String au = sc.nextLine();

				System.out.print("가격 > ");
				String pr = sc.nextLine();

				
//				bk = new Book();
//				bk.setTitle(ti);
//				bk.setAuthor(au);
//				bk.setPrice(pr);
//
//				if (dao.updateBook(bk)) {
//					System.out.println("수정완료");
//				} else {
//					System.out.println("처리실패");
//				}
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
		while(run3) {
			
			System.out.println(" 1.도서신규등록 2.도서정보수정 3.도서삭제 4.돌아가기");
			System.out.println("선택>> ");
			int ch2 = sc.nextInt();
			sc.nextLine();
		
//		switch (ch2) {
//		case 1:
//			System.out.print("- 도서 신규 등록");
//			
//			search.setBookNo(sc.nextLine());
//			break;
//		case 2:
//			System.out.print("도서제목를 입력하세요> ");
//			search.setTitle(sc.nextLine());
//			break;
//
//		case 3:
//			System.out.print("저자를 입력하세요> ");
//			search.setAuthor(sc.nextLine());
//			break;
//
//		case 4:
//			run2 = false;
//			return;
//		}

		System.out.println("도서명> ");
		String ti = sc.nextLine();

		System.out.println("구매일자> ");
		String bu = sc.nextLine();

		System.out.println("저자> ");
		String au = sc.nextLine();

		System.out.println("가격> ");
		String pr = sc.nextLine();

		Book bk = new Book();
		bk.setTitle(ti);
		bk.setBuydate(bu);
		bk.setAuthor(au);
		bk.setPrice(pr);

		if (dao.insertBook(bk)) {
			System.out.println("정상등록");
		} else {
			System.out.println("예외발생");
		}
		}
	}
	
	void manageMember() {
		List<Member> mem = dao.memberList();
		System.out.println("회원번호	회원명	 회원연락처 		대출도서번호 연체여부");
		System.out.println("------------------------------------------------------------------------");
		for (Member mm : mem) {
			System.out.println(mem.toString());
		}
		
	}
	
} // end of class.
