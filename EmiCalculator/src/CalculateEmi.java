
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
			double r = Double.parseDouble(req.getParameter("rate"));
			double emi = 0.0, principalPerMonth = 0.0, balancePrincipal = amount, rate = 0.0;

			rate = (r / 12) / 100;
			emi = (amount * rate * (double) Math.pow(1 + rate, time)) / (double) (Math.pow(1 + rate, time) - 1);

			double finalEmi = Math.round(emi);
			double totalInt = Math.round((finalEmi * time) - amount);
			double totalAmt = Math.round(finalEmi * time);
			double intPerMonth = Math.round(totalInt / time);

			for (int i = 1, j = 1; i <= time; i++) {
				intPerMonth = (balancePrincipal * rate);
				balancePrincipal = ((balancePrincipal) - ((finalEmi) - (intPerMonth)));
				principalPerMonth = Math.round(finalEmi - intPerMonth);
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
				list.add(new EMI(mName, finalEmi, Math.round(intPerMonth), principalPerMonth, Math.round(balancePrincipal)));
				if (j == 13)
					j /= 12;
			}
			req.setAttribute("totalPlan", new EMI(r, amount, totalInt, totalAmt, time));
			req.setAttribute("data", list);
			req.getRequestDispatcher("/emi.jsp").forward(req, resp);
		} catch (Throwable throwable) {
			resp.getWriter().write("" + throwable);
		}
	}

}
