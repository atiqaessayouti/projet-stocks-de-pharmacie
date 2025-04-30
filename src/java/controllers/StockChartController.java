package controllers;


import com.google.gson.Gson;
import mapper.MedicamentStockCount;
import services.MedicamentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/stockChart")
public class StockChartController extends HttpServlet {
    
    private final MedicamentService medicamentService = new MedicamentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MedicamentStockCount> stockCounts = medicamentService.countStockPerMedicament();
        String json = new Gson().toJson(stockCounts);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
