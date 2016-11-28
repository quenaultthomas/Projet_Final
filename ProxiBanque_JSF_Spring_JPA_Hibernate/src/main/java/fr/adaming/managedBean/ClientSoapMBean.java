package fr.adaming.managedBean;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.cdyne.ws.DelayedStockQuote;
import com.cdyne.ws.DelayedStockQuoteSoap;
import com.cdyne.ws.QuoteData;

@ManagedBean(name="SoapMBean")
public class ClientSoapMBean {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */

	private DelayedStockQuote stub = new DelayedStockQuote();
	
	private DelayedStockQuoteSoap service = stub.getDelayedStockQuoteSoap();
	
	private QuoteData fordMotorCompany;
	private QuoteData agilentTech;
	private QuoteData barnesG;
	private QuoteData cityG;
	private QuoteData societe;
	private BarChartModel barModel;
	
	private String stockSymbol;
//----------------------------------------------------------------------------------------------------------------
//---------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */

	/**
	 * Constructeur vide
	 */
	public ClientSoapMBean() {
	}
	
//----------------------------------------------------------------------------------------------------------------
//---------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
    /**
	 * @return the barModel
	 */
	public BarChartModel getBarModel() {
		return barModel;
	}
	
	/**
	 * @param barModel the barModel to set
	 */
	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
	
	/**
	 * @return the societe
	 */
	public QuoteData getSociete() {
		return societe;
	}

	/**
	 * @param societe the societe to set
	 */
	public void setSociete(QuoteData societe) {
		this.societe = societe;
	}

	/**
	 * @return the stockSymbol
	 */
	public String getStockSymbol() {
		return stockSymbol;
	}

	/**
	 * @param stockSymbol the stockSymbol to set
	 */
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	
	public String retourIndex(){
		return "index.xhtml";
	}
	
	public String retourBourse(){
		return "bourse.xhtml";
	}
	
	public String redirectBR(){
		return "bourse_recherche.xhtml";
	}
	
	public void quotebyStockSymbol(){
		societe= service.getQuote(stockSymbol, "0");

	}
	
	 private BarChartModel initBarModel() {
	        BarChartModel model = new BarChartModel();
	        
	        fordMotorCompany = service.getQuote("F", "0");
			agilentTech = service.getQuote("A", "0");
			barnesG = service.getQuote("B", "0");
			cityG = service.getQuote("c", "0");
			
			
	        ChartSeries openAmount = new ChartSeries();
	        openAmount.setLabel("Last Trade Amount");
	        openAmount.set(fordMotorCompany.getCompanyName(), fordMotorCompany.getOpenAmount());
	        openAmount.set(agilentTech.getCompanyName(), agilentTech.getOpenAmount());
	        openAmount.set(barnesG.getCompanyName(),barnesG.getOpenAmount());
	        openAmount.set(cityG.getCompanyName(), cityG.getOpenAmount());
	             
	        ChartSeries pE = new ChartSeries();
	        pE.setLabel("PE");
	        pE.set(fordMotorCompany.getCompanyName(), fordMotorCompany.getPE());
	        pE.set(agilentTech.getCompanyName(), agilentTech.getPE());
	        pE.set(barnesG.getCompanyName(),barnesG.getPE());
	        pE.set(cityG.getCompanyName(), cityG.getPE());
	        
	        model.addSeries(openAmount);
	        model.addSeries(pE);
	        
	        return model;
	    }

		public String createBarModels() {
	        createBarModel();
	        return "bourse.xhtml";

	    }
	     
	    private void createBarModel() {
	        barModel = initBarModel();
	         
	        barModel.setTitle("Delayed Stock Quote");
	        barModel.setLegendPosition("ne");
	         
	        Axis xAxis = barModel.getAxis(AxisType.X);
	        xAxis.setLabel("Company");
	         
	        Axis yAxis = barModel.getAxis(AxisType.Y);
	        yAxis.setLabel("Point");
//	        yAxis.setMin(0);
//	        yAxis.setMax(10);
	    }
	
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
}
