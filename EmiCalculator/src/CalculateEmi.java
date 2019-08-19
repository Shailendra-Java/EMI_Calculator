
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.util.EMI;

@WebServlet("/CalculateEmi")
public class CalculateEmi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<EMI> list;
	private String mName = null;

	public CalculateEmi() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			list = new ArrayList<>();
			double amount = Double.parseDouble(req.getParameter("pAmount"));
			int time = Integer.parseInt(req.getParameter("month"));
			double rate = Double.parseDouble(req.getParameter("rate"));
			double emi = 0.0, temp = 0.0, interestPerMonth = 0.0;
			temp = 100 * time;
			interestPerMonth = rate / temp;
			rate = rate / (12 * 100);
			time = time * 12;
			emi = (amount * interestPerMonth * (double) Math.pow(1 + interestPerMonth, time/12))
					/ (double) (Math.pow(1 + interestPerMonth, time/12) - 1);
			double finalEmi = Math.round(emi * 100.0) / 100.0;
			for (int i = 1, j = 1; i <= time/12; i++) {
				amount -= finalEmi;
				switch (j) {
				case 1:
					mName = "Jan";
					break;
				case 2:
					mName = "Feb";
					break;
				case 3:
					mName = "Mar";
					break;
				case 4:
					mName = "Apr";
					break;
				case 5:
					mName = "May";
					break;
				case 6:
					mName = "Jun";
					break;
				case 7:
					mName = "Jul";
					break;
				case 8:
					mName = "Aug";
					break;
				case 9:
					mName = "Sep";
					break;
				case 10:
					mName = "Oct";
					break;
				case 11:
					mName = "Nov";
					break;
				case 12:
					mName = "Dec";
					break;
				}
				j++;
				list.add(new EMI(interestPerMonth, amount, mName));
				if (j == 13)
					j /= 12;
			}
			req.setAttribute("emi", finalEmi);
			req.setAttribute("data", list);
			req.getRequestDispatcher("/emi.jsp").forward(req, resp);
		} catch (Throwable throwable) {
			resp.getWriter().write("" + throwable);
		}
	}

}
