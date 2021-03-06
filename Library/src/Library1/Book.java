package Library1;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {

	Scanner sc= new Scanner(System.in);
	private String bNo;
	private String bTitle;
	private String bAuthor;
	private String bGenre;
	private boolean bAvailable;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	public Book() {
		
	}

	public String getbNo() {
		return bNo;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	public String getbGenre() {
		return bGenre;
	}

	public void setbGenre(String bGenre) {
		this.bGenre = bGenre;
	}

	public boolean isbAvailable() {
		return bAvailable;
	}

	public void setbAvailable(boolean bAvailable) {
		this.bAvailable = bAvailable;
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	
	public void showMain() throws InterruptedException {
		while(true) {
			System.out.println("도서관에 오신걸 완영합니다.");
			System.out.println("[1]도서등록\t[2]전체조회\t[3]개별조회\t[4]책 정보 수정\t[5]책 삭제\n[6]도서 반납 및 대여\t[0]종료");
			String userInput=sc.nextLine();
			
			switch(userInput) {
			case("1"):insertBook();
			break;
			case("2"):selectAll();
			break;
			case("3"):selectOne();
			break;
			case("4"):updateBook();
			break;
			case("5"):deletebook();
			break;
			case("6"):checkBook();
			break;
			case("0"):
				System.out.println("프로그램을 종료합니다.");
			sc.close();
			System.exit(0);
			default:
				System.out.println("잘못 입력하셨습니다.다시 입력하세요.");
				break;
			}
		}
	}
	
	public void insertBook() throws InterruptedException {
		while(true) {
			Book bk = new Book();
			
			while(true) {
				int cnt=0;
				System.out.println("도서 번호 입력");
				String temp = sc.nextLine();
				for(int i = 0;i<bookList.size();i++) {
					if(temp.equals(bookList.get(i).getbNo())) {
//						System.out.println(bookList.get(i).getbNo());
						cnt++;
						System.out.println("도서 번호 중복입니다.다시 입력하세요.");
						break;
					}
				}
				if(cnt==0) {
					bk.setbNo(temp);
					break;
				}
			}
			System.out.println("책 제목 입력");
			bk.setbTitle(sc.nextLine());
			System.out.println("작가 입력");
			bk.setbAuthor(sc.nextLine());
			System.out.println("장르 입력");
			bk.setbGenre(sc.nextLine());
			bk.setbAvailable(true);
			Thread.sleep(1000);
			
			System.out.println("도서번호:"+bk.getbNo());
			System.out.println("도서제목:"+bk.getbTitle());
			System.out.println("지은이:"+bk.getbAuthor());
			System.out.println("장 르:"+bk.getbGenre());
			System.out.println("대여가능:"+bk.isbAvailable());
			
			System.out.println("입력하신 사항이 모두 맞습니까? 예(Y) 아니요(N)");
			String confirm = sc.nextLine();
			if(confirm.equalsIgnoreCase("y")) {
				bookList.add(bk);
				System.out.println("입력 완료");
				break;
		}
				else if(confirm.equalsIgnoreCase("n")) {
					System.out.println("도서 정보를 다시 입력하세요.");
				}else {
					System.out.println("잘못 누르셨습니다.초기 메뉴로 이동합니다.");
					break;
				}
			}
		Thread.sleep(1000);
		}
	
		public void selectAll() throws InterruptedException {
			while(true) {
				System.out.println("보유 도서량: " +bookList.size());
				for(int i =0;i<bookList.size();i++) {
					System.out.println("----------------");
					System.out.println("책 번호 : " +bookList.get(i).getbNo());
					System.out.println("책 제목 : "+bookList.get(i).getbTitle());
					System.out.println("지은이 : "+bookList.get(i).getbAuthor());
					System.out.println("장 르 : "+bookList.get(i).getbGenre());
					System.out.println("대여가능 : "+bookList.get(i).isbAvailable());
					System.out.println("----------------\n");
					
				}//end for
				System.out.println("초기 메뉴 이동:[b]\t	프로그램 종료:[0]");
				String temp=sc.nextLine();
				if(temp.equalsIgnoreCase("b")) {
					break;
				}else if(temp.equals("0")) {
					System.out.println("프로그램을 종료합니다.");
					Thread.sleep(1000);
					System.exit(0);
				}else {
					System.out.println("잘못 누르셨습니다.초기화면으로 돌아갑니다.");
					Thread.sleep(1000);
					break;
				}
				
			}
		}
	
	
		public void selectOne() {
			while(true) {
				System.out.println("검색 할 책의 번호를 입력해주세요.");
				String temp=sc.nextLine();
				int cnt=0;
				for(int i =0;i<bookList.size();i++) {
					if(temp.equals(bookList.get(i).getbNo())) {
						System.out.println("====================");
						System.out.println("책 번호 : "+bookList.get(i).getbNo());
						System.out.println("책 제목 : "+bookList.get(i).getbTitle());
						System.out.println("지은이 : "+bookList.get(i).getbAuthor());
						System.out.println("장 르 : "+bookList.get(i).getbGenre());
						System.out.println("대여가능 : "+bookList.get(i).isbAvailable());
						System.out.println("====================\n");
						cnt++;
						break;
					}
				}
				if(cnt==0) {
					System.out.println("해당 도서가 존재하지 않습니다.도서 번호를 다시 입력하세요.");
				}else {
					break;
				}
			}
		}
		
		public void updateBook() {
			while(true) {
				System.out.println("수정 할 책의 번호를 입력해주세요.");
				String temp= sc.nextLine();
				int cnt=0;
				for(int i=0;i<bookList.size();i++) {
					if(temp.equals(bookList.get(i).getbNo())) {
						System.out.println("새로운 제목 입력...");
						bookList.get(i).setbTitle(sc.nextLine());
						System.out.println("새로운 지은이 입력...");
						bookList.get(i).setbAuthor(sc.nextLine());
						System.out.println("새로운 장르 입력...");
						bookList.get(i).setbGenre(sc.nextLine());
						cnt++;
						System.out.println("도서 수정 완료");
						break;
					}
				}
				if(cnt ==0) {
					System.out.println("해당 도서가 존재하지 않습니다.도서 번호를 다시 입력해주세요.");					
				}else {
					break;
				}
			}
		}
		
		public void deletebook() {
			while(true) {
				System.out.println("삭제 할 책의 번호를 입력해주세요.");
				String temp=sc.nextLine();
				int cnt=0;
				for(int i =0;i<bookList.size();i++) {
					if(temp.equals(bookList.get(i).getbNo())) {
						bookList.remove(i);
						cnt++;
						System.out.println("도서 삭제 완료");
						break;
					}
				}
				if(cnt==0) {
					System.out.println("해당 도서가 존재하지 않습니다.");
				}else {
					break;
				}
			}		
				}
		public void checkBook() {
			while(true) {
				System.out.println("해당 도서의 번호를 입력해주세요.");
				String temp=sc.next();
				int cnt=0;
				for(int i =0;i<bookList.size();i++) {
					if(temp.equals(bookList.get(i).getbNo())) {
						cnt++;
						boolean bStatus=bookList.get(i).isbAvailable();
						
					if(bStatus) {
						bStatus = false;
						System.out.println("도서가 대여되었습니다.");
					}else {
						bStatus=true;
						System.out.println("도서가 반납되었습니다.");
					}
					bookList.get(i).setbAvailable(bStatus);
					break;
					}
				}
				if(cnt==0) {
					System.out.println("해당 도서가 존재하지 않습니다.도서 번호를 입력해주세요.");
				}else {
					break;
				}
		}
	}
}

