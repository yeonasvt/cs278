import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Tory Yeonas
//October 18, 2016
//Team 6 - React.js

public class ReactGradingScript {

	public static void main(String[] args) throws IOException {
		int grade = 0;
		
		//Grade App.js 
		BufferedReader br = new BufferedReader(new FileReader("App.js"));
		
		String ans = "curpage:\'create\'"; //worth 3 points
		
		String curr = br.readLine();
		
		while (curr != null) {
			if (curr.replaceAll("\\s","").contains(ans)){
				System.out.println(curr);
				grade += 3;
				curr = null;
			} else {
				curr = br.readLine();
			}
		}
		
		br.close();
		
		//Grade AllDormitories.js
		BufferedReader br2 = new BufferedReader(new FileReader("AllDormitories.js"));
		
		String ans1 = "this.setState({dorms:data})"; //worth 3 points
		String ans2 = "\'GET\'"; //worth 1 point
		String ans3 = "<th>ID</th>"; //worth 2 points
		String ans4 = "<th>Name</th>"; //worth 2 points
		
		curr = br2.readLine();
		
		while (curr != null) {
			if (curr.replaceAll("\\s", "").contains(ans1)){
				System.out.println(curr);
				grade += 3;
			} else if(curr.replaceAll("\\s","").contains(ans2)) {
				System.out.println(curr); 
				grade++;
			} else if (curr.replaceAll("\\s", "").contains(ans3)) {
				System.out.println(curr);
				grade += 2;
			} else if (curr.replaceAll("\\s", "").contains(ans4)) {
				System.out.println(curr);
				grade += 2;
			} 
			curr = br2.readLine();
			
		}
		
		br2.close();
		
		//Grade AddDormitory.js
		BufferedReader br3 = new BufferedReader(new FileReader("AddDormitory.js"));
		
		String ans5 = "dormName:\'default_dorm\'"; //worth 2 points
		String ans6 = "this.setState({dormName:event.target.value})"; //worth 3 points
		String ans7 = "this.setState({dormID:event.target.value})"; //worth 3 points
		String ans8 = "\'POST\'"; //worth 1 point
		
		curr = br3.readLine();
		
		while (curr!= null) {
			if (curr.replaceAll("\\s", "").contains(ans5)) {
				System.out.println(curr);
				grade += 2;
			} else if (curr.replaceAll("\\s", "").contains(ans6)) {
				System.out.println(curr);
				grade += 3;
			} else if (curr.replaceAll("\\s", "").contains(ans7)) {
				System.out.println(curr);
				grade +=3;
			} else if (curr.replaceAll("\\s", "").contains(ans8)) {
				System.out.println(curr);
				grade++;
			}
			curr = br3.readLine();
		}
		
		br3.close();
		
		System.out.println("Grade: " + grade);
		

	}

}
