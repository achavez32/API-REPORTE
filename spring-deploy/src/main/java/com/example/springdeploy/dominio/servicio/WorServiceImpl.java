package com.example.springdeploy.dominio.servicio;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;
import org.springframework.stereotype.Service;

import com.example.springdeploy.dominio.dto.DtoLetraVenta;

@Service
public class WorServiceImpl {
	// metodo para netbeasn llamada de valor
		public byte[] generarRequerimientoPago(DtoLetraVenta letraVentas) {
			
			try {
				XWPFDocument docx = new XWPFDocument();
				CTSectPr sectPr = docx.getDocument().getBody().addNewSectPr();
				XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(docx, sectPr);

				XWPFParagraph headerParagraph = new XWPFParagraph(CTP.Factory.newInstance(), docx);
				XWPFRun runEncabezado = headerParagraph.createRun();
				headerParagraph.setAlignment(ParagraphAlignment.CENTER);

				runEncabezado.setFontSize(18);
				runEncabezado.setFontFamily("Bookman Old Style");
				runEncabezado.setBold(true);
				runEncabezado.setText("CONSTRUCTORA E INMOBILIARIA");
				runEncabezado.addBreak();
				//DtoVenta venta = letraVentas.get(0).getVenta();
				//DtoEmpresa empresa = venta.getLote().getManzana().getPrograma().getCompraLote().getSucursal().getEmpresa();

				//runEncabezado.setText(empresa.getRsCorto().toUpperCase());
				runEncabezado.setText("ANGEL CHAVEZ S.A.C");
				runEncabezado.addBreak();

				XWPFRun encabezadoDireccionRun = headerParagraph.createRun();
				encabezadoDireccionRun.setFontSize(11);
				encabezadoDireccionRun.setBold(true);
				encabezadoDireccionRun.setFontFamily("Times New Roman");
				//encabezadoDireccionRun.setText(empresa.getDireccionPrincipal() + " TEL: " + empresa.getTelefono());
				encabezadoDireccionRun.setText("LAS FLORES SJL" + " TEL: " + "933086348");
				
				headerParagraph.setAlignment(ParagraphAlignment.CENTER);
				XWPFParagraph[] parsHeader = new XWPFParagraph[1];
				parsHeader[0] = headerParagraph;

				policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);
				// write footer content
				XWPFParagraph footerParagraph = new XWPFParagraph(CTP.Factory.newInstance(), docx);

				XWPFRun runPie = footerParagraph.createRun();
				runPie.setFontSize(10);
				runPie.setFontFamily("Times New Roman");
				runPie.setText(
						"*Si a la fecha de recepci�n de la presente, Usted hubiera regularizado su situaci�n,"
						+ " le agradeceremos dejar sin efecto este documento."
						+ " Todo pago se realiza en las oficinas de la empresa");

				XWPFParagraph[] parsFooter = new XWPFParagraph[1];
				parsFooter[0] = footerParagraph;
				policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);

				// write body content

				// PARRAFO DE TITULO - INCIO
				XWPFParagraph tituloParrafoCuerpo = docx.createParagraph();
				tituloParrafoCuerpo.setAlignment(ParagraphAlignment.CENTER);

				XWPFRun tituloRunCuerpo = tituloParrafoCuerpo.createRun();
				tituloRunCuerpo.setBold(true);
				tituloRunCuerpo.setText("REQUERIMIENTO DE PAGO");
				tituloRunCuerpo.setUnderline(UnderlinePatterns.SINGLE);
				tituloRunCuerpo.setBold(true);
				tituloRunCuerpo.setItalic(true);
				tituloRunCuerpo.setFontFamily("Times New Roman");
				tituloRunCuerpo.setFontSize(20);
				tituloRunCuerpo.setColor("333333");
				tituloRunCuerpo.addBreak();

				// PARRAFO DE TITULO - FIN

				// PARRAFO DE FECHA - INCIO
				XWPFParagraph fechaParrafoCuerpo = docx.createParagraph();
				fechaParrafoCuerpo.setAlignment(ParagraphAlignment.RIGHT);

				Date c = new Date();

				XWPFRun fechaRunCuerpo = fechaParrafoCuerpo.createRun();
				fechaRunCuerpo.setBold(true);
				fechaRunCuerpo.setText( /*empresa.getDistrito()*/ "San Juan de Lurigancho" + ", " + "" + new SimpleDateFormat("dd").format(c) + " de "
						+ "" + new SimpleDateFormat("MM").format(c) + " del " + "" + new SimpleDateFormat("yyyy").format(c));
				fechaRunCuerpo.setItalic(true);
				fechaRunCuerpo.setBold(true);
				fechaRunCuerpo.setFontFamily("Times New Roman");
				fechaRunCuerpo.setFontSize(12);
				fechaRunCuerpo.setColor("333333");
				// PARRAFO DE FECHA - FIN

				// PARRAFO DE RECEPTOR - INCIO
				XWPFParagraph receptorParrafoCuerpo = docx.createParagraph();
				receptorParrafoCuerpo.setAlignment(ParagraphAlignment.LEFT);

				XWPFRun receptorRunCuerpo = receptorParrafoCuerpo.createRun();
				receptorRunCuerpo.setBold(true);
				receptorRunCuerpo.setText("Se�or(es):");
				receptorRunCuerpo.addBreak();
				//DtoCliente cliente = venta.getCliente();
			//	receptorRunCuerpo.setText((cliente.getNombres()+" "+cliente.getApellidos()).toUpperCase());
				receptorRunCuerpo.setText(("ANGEL CHAVEZ.."+" "+"CHAVEZ AGUSTIN..").toUpperCase());
//				receptorRunCuerpo.setText("MARIA ROSA REQUE DE CARAVALLO");
				receptorRunCuerpo.addBreak();
				//receptorRunCuerpo.setText(cliente.getDireccion().toUpperCase());
				receptorRunCuerpo.setText("SJL");
//				receptorRunCuerpo.setText("CALLE VENEZUELA MZ. 'L' LOTE 05 URB. AMERICA - OQUENDO CALLAO");

				receptorRunCuerpo.setFontFamily("");
				receptorRunCuerpo.setFontSize(12);
				receptorRunCuerpo.setBold(true);
				receptorRunCuerpo.setFontFamily("Times New Roman");
				receptorRunCuerpo.setItalic(true);
				receptorRunCuerpo.setColor("333333");
				// PARRAFO DE RECEPTOR - FIN

				// PARRAFO DE REFERENCIA - INCIO
				XWPFParagraph referenciaParrafoCuerpo = docx.createParagraph();
				referenciaParrafoCuerpo.setAlignment(ParagraphAlignment.LEFT);

				XWPFRun _1 = referenciaParrafoCuerpo.createRun();
				_1.setText("Referencia: Programa de Vivienda: ");
				_1.setFontFamily("Times New Roman");
				_1.setItalic(true);
				_1.setFontSize(12);
				_1.setColor("333333");
				//DtoLote lote = venta.getLote();
				XWPFRun _2 = referenciaParrafoCuerpo.createRun();
				_2.setText("�"+ /*lote.getManzana().getPrograma().getNombre()*/ "NOMBRE PROGRAMA.." +"� MZ. �"+ /*lote.getManzana().getDescripcion()*/ "LOTE DE MANZANA...." +"� LT. "+ /*lote.getDescripcion()*/ "DESCRIPCION LOTE..." );
				_2.setFontFamily("Times New Roman");
				_2.setItalic(true);
				_2.setBold(true);
				_2.setFontSize(12);
				_2.addBreak();
				_2.setColor("333333");

				XWPFRun _3 = referenciaParrafoCuerpo.createRun();
				_3.setText("Asunto: Obligaciones de 02 letras vencidas: ");
				_3.setFontFamily("Times New Roman");
				_3.setItalic(true);
				_3.setBold(false);
				_3.setFontSize(12);
				_3.setColor("333333");

				XWPFRun _4 = referenciaParrafoCuerpo.createRun();
				double suma = 0;
			//	for (DtoLetraVenta lv : letraVentas) {
				//	suma+=lv.getMonto();
			//	}
				_4.setText( /*venta.getTipoMoneda().getDescripcion()*/"TIPO DE MANEDA DESC..." +" "+String.format("%,.2f", (float)Math.round((suma*100)/100)))  ;	
				
//				_4.setText("US$. 286.00");
				_4.setFontFamily("Times New Roman");
				_4.setItalic(true);
				_4.setBold(true);
				_4.setFontSize(12);
				_4.addBreak();
				_4.setColor("333333");

				XWPFRun _5 = referenciaParrafoCuerpo.createRun();
				
				
				_5.setText("Desde la Letra N� "+""+" f/v "+new SimpleDateFormat("dd/MM/yyyy").format( new Date() /*letraVentas.get(0).getFechaVencimiento()*/)+""
						+ "	hasta la Letra N� "+"" +" f/v "+new SimpleDateFormat("dd/MM/yyyy").format( new Date()/*letraVentas.get(1).getFechaVencimiento()*/));
				_5.setFontFamily("Times New Roman");
				_5.setItalic(true);
				_5.setBold(true);
				_5.setFontSize(12);
				_5.addBreak();
				_5.setColor("333333");

				XWPFRun _6 = referenciaParrafoCuerpo.createRun();
				_6.setText("M�s intereses correspondiente. ");
				_6.setFontFamily("Times New Roman");
				_6.setItalic(true);
				_6.setBold(false);
				_6.setFontSize(12);
				_6.setColor("333333");

				XWPFRun _7 = referenciaParrafoCuerpo.createRun();
				_7.setText("(Sujeto a Resoluci�n)");
				_7.setFontFamily("Times New Roman");
				_7.setUnderline(UnderlinePatterns.SINGLE);
				_7.setItalic(true);
				_7.setBold(true);
				_7.setFontSize(12);
				_7.addBreak();
				_7.setColor("333333");

				// PARRAFO DE REFERENCIA - FIN

				// PARRAFO CENTRAL - INCIO (1)
				XWPFParagraph centralParrafoCuerpo_1 = docx.createParagraph();
				centralParrafoCuerpo_1.setAlignment(ParagraphAlignment.THAI_DISTRIBUTE);
				CTPPr ppr_1 = centralParrafoCuerpo_1.getCTP().getPPr();
				if (ppr_1 == null)
					ppr_1 = centralParrafoCuerpo_1.getCTP().addNewPPr();
				CTSpacing spacing_1 = ppr_1.isSetSpacing() ? ppr_1.getSpacing() : (CTSpacing) ppr_1.addNewSpacing();
				spacing_1.setAfter(BigInteger.valueOf(0));
				spacing_1.setBefore(BigInteger.valueOf(0));
				spacing_1.setLineRule(STLineSpacingRule.EXACT);
				spacing_1.setLine(BigInteger.valueOf(0));

				XWPFRun centralRunCuerpo_1 = centralParrafoCuerpo_1.createRun();
				centralRunCuerpo_1.getCTR().addNewTab();
				centralRunCuerpo_1.setText("Le comunicamos que hemos realizado todos los intentos a fin de"
						+ " solucionar su deuda con nuestra representada en forma conciliatoria y por su"
						+ " constante negativa en asumir su obligaci�n ha decidido usted guardar silencio"
						+ " rechazando las invitaciones y/o alternativas posibles a fin de regularizar su"
						+ " situaci�n, raz�n por la cual nos vemos en la imperiosa necesidad de informarle"
						+ " que las letras de cambio aceptadas pasaran a la cobranza judicial.");

				centralRunCuerpo_1.setFontFamily("Times New Roman");
				centralRunCuerpo_1.setFontSize(12);
				centralRunCuerpo_1.setItalic(true);
				centralRunCuerpo_1.setColor("333333");
				// PARRAFO CENTRAL - FIN (1)

				// PARRAFO CENTRAL - INCIO (1-1)
				XWPFParagraph centralParrafoCuerpo_1_1 = docx.createParagraph();
				centralParrafoCuerpo_1_1.setAlignment(ParagraphAlignment.THAI_DISTRIBUTE);
				centralParrafoCuerpo_1_1.setSpacingLineRule(LineSpacingRule.AT_LEAST);
				CTPPr ppr = centralParrafoCuerpo_1_1.getCTP().getPPr();
				if (ppr == null)
					ppr = centralParrafoCuerpo_1_1.getCTP().addNewPPr();
				CTSpacing spacing = ppr.isSetSpacing() ? ppr.getSpacing() : (CTSpacing) ppr.addNewSpacing();
				spacing.setAfter(BigInteger.valueOf(0));
				spacing.setBefore(BigInteger.valueOf(0));
				spacing.setLineRule(STLineSpacingRule.EXACT);
				spacing.setLine(BigInteger.valueOf(0));

				XWPFRun centralRunCuerpo_1_1 = centralParrafoCuerpo_1_1.createRun();

				centralRunCuerpo_1_1.getCTR().addNewTab();
				centralRunCuerpo_1_1.setText("A partir de la fecha toda negociaci�n y/o pago ser� con nuestro "
						+ "departamento legal precisando siempre que la deuda se incrementar� notablemente por "
						+ "los intereses, moras y gastos administrativos que se ocasionen hasta la satisfacci�n "
						+ "total del monto adeudado.");

				centralRunCuerpo_1_1.setFontFamily("Times New Roman");
				centralRunCuerpo_1_1.setFontSize(12);
				centralRunCuerpo_1_1.setItalic(true);
				centralRunCuerpo_1_1.setColor("333333");
				// PARRAFO CENTRAL - FIN (1-1)

				// PARRAFO CENTRAL - INCIO (2)
				XWPFParagraph centralParrafoCuerpo_2 = docx.createParagraph();
				centralParrafoCuerpo_2.setAlignment(ParagraphAlignment.THAI_DISTRIBUTE);
				CTPPr ppr_2 = centralParrafoCuerpo_2.getCTP().getPPr();
				if (ppr_2 == null)
					ppr_2 = centralParrafoCuerpo_2.getCTP().addNewPPr();
				CTSpacing spacing_2 = ppr_2.isSetSpacing() ? ppr_2.getSpacing() : (CTSpacing) ppr_2.addNewSpacing();
				spacing_2.setAfter(BigInteger.valueOf(0));
				spacing_2.setBefore(BigInteger.valueOf(0));
				spacing_2.setLineRule(STLineSpacingRule.EXACT);
				spacing_2.setLine(BigInteger.valueOf(0));

				XWPFRun centralRunCuerpo_2 = centralParrafoCuerpo_2.createRun();

				centralRunCuerpo_2.getCTR().addNewTab();
				centralRunCuerpo_2.setText("Le invocamos que reflexione sobre su situaci�n jur�dica y con sentido "
						+ "com�n y en forma sensata cumpla con honrar su deuda con nuestra representada y evite "
						+ "comprometer su patrimonio y su tiempo con un proceso judicial que terminara declarando "
						+ "fundada nuestra pretensi�n, Adicionalmente a la presentaci�n de cualquier acci�n administrativa "
						+ "y/o judicial solicitaremos las medidas cautelares correspondientes tales como embargo y/o "
						+ "secuestros en la direcci�n consignada en las c�mbiales y/o contrato compra-venta");

				centralRunCuerpo_2.setFontFamily("Times New Roman");
				centralRunCuerpo_2.setFontSize(12);
				centralRunCuerpo_2.setItalic(true);
				centralRunCuerpo_2.setColor("333333");
				// PARRAFO CENTRAL - FIN (2)

				// PARRAFO CENTRAL - INCIO (3)
				XWPFParagraph centralParrafoCuerpo_3 = docx.createParagraph();
				centralParrafoCuerpo_3.setAlignment(ParagraphAlignment.THAI_DISTRIBUTE);
				centralParrafoCuerpo_3.setSpacingLineRule(LineSpacingRule.AT_LEAST);
				CTPPr ppr_3 = centralParrafoCuerpo_3.getCTP().getPPr();
				if (ppr_3 == null)
					ppr_3 = centralParrafoCuerpo_3.getCTP().addNewPPr();
				CTSpacing spacing_3 = ppr_3.isSetSpacing() ? ppr_3.getSpacing() : (CTSpacing) ppr_3.addNewSpacing();
				spacing_3.setAfter(BigInteger.valueOf(0));
				spacing_3.setBefore(BigInteger.valueOf(0));
				spacing_3.setLineRule(STLineSpacingRule.EXACT);
				spacing_3.setLine(BigInteger.valueOf(0));

				XWPFRun centralRunCuerpo_3 = centralParrafoCuerpo_3.createRun();

				centralRunCuerpo_3.getCTR().addNewTab();
				centralRunCuerpo_3
						.setText("No obstante, lo indicado en los p�rrafos precedentes, lo invitamos para que en el "
								+ "plazo perentorio de 48 horas de recepcionada la presente se apersone a nuestras oficinas para "
								+ "regularizar su obligaci�n. En el supuesto de que no concurran en el plazo indicado ejerceremos "
								+ "las acciones legales correspondientes.");

				centralRunCuerpo_3.setFontFamily("Times New Roman");
				centralRunCuerpo_3.setFontSize(12);
				centralRunCuerpo_3.setItalic(true);
				centralRunCuerpo_3.setColor("333333");
				// PARRAFO CENTRAL - FIN (3)

				// PARRAFO CENTRAL - INCIO (4)
				XWPFParagraph centralParrafoCuerpo_4 = docx.createParagraph();
				centralParrafoCuerpo_4.setAlignment(ParagraphAlignment.THAI_DISTRIBUTE);
				centralParrafoCuerpo_4.setSpacingLineRule(LineSpacingRule.AT_LEAST);
				CTPPr ppr_4 = centralParrafoCuerpo_4.getCTP().getPPr();
				if (ppr_4 == null)
					ppr_4 = centralParrafoCuerpo_4.getCTP().addNewPPr();
				CTSpacing spacing_4 = ppr_4.isSetSpacing() ? ppr_4.getSpacing() : (CTSpacing) ppr_4.addNewSpacing();
				spacing_4.setAfter(BigInteger.valueOf(0));
				spacing_4.setBefore(BigInteger.valueOf(0));
				spacing_4.setLineRule(STLineSpacingRule.EXACT);
				spacing_4.setLine(BigInteger.valueOf(0));

				XWPFRun centralRunCuerpo_4 = centralParrafoCuerpo_4.createRun();
				centralRunCuerpo_4.getCTR().addNewTab();
				centralRunCuerpo_4
						.setText("Esperando se sirva visitarnos en el plazo encomendado nos suscribimos de usted.");

				centralRunCuerpo_4.setFontFamily("Times New Roman");
				centralRunCuerpo_4.setFontSize(12);
				centralRunCuerpo_4.setItalic(true);
				centralRunCuerpo_4.setColor("333333");
				// PARRAFO CENTRAL - FIN (4)

				// PARRAFO CENTRAL - INCIO (5)
				XWPFParagraph centralParrafoCuerpo_5 = docx.createParagraph();

				centralParrafoCuerpo_5.setAlignment(ParagraphAlignment.THAI_DISTRIBUTE);
				centralParrafoCuerpo_5.setSpacingLineRule(LineSpacingRule.AT_LEAST);
				CTPPr ppr_5 = centralParrafoCuerpo_5.getCTP().getPPr();
				if (ppr_5 == null)
					ppr_5 = centralParrafoCuerpo_5.getCTP().addNewPPr();
				CTSpacing spacing_5 = ppr_5.isSetSpacing() ? ppr_5.getSpacing() : (CTSpacing) ppr_5.addNewSpacing();
				spacing_5.setAfter(BigInteger.valueOf(0));
				spacing_5.setBefore(BigInteger.valueOf(0));
				spacing_5.setLineRule(STLineSpacingRule.EXACT);
				spacing_5.setLine(BigInteger.valueOf(0));

				XWPFRun centralRunCuerpo_5 = centralParrafoCuerpo_5.createRun();

				centralRunCuerpo_5.addBreak();
				centralRunCuerpo_5.getCTR().addNewTab();
				centralRunCuerpo_5.getCTR().addNewTab();
				centralRunCuerpo_5.getCTR().addNewTab();
				centralRunCuerpo_5.getCTR().addNewTab();
				centralRunCuerpo_5.getCTR().addNewTab();
				centralRunCuerpo_5.getCTR().addNewTab();
				centralRunCuerpo_5.setColor("333333");

				centralRunCuerpo_5.setText("Atentamente");

				centralRunCuerpo_5.setFontFamily("Roman");
				centralRunCuerpo_5.setFontSize(10);
				centralRunCuerpo_5.setColor("333333");
				// PARRAFO CENTRAL - FIN (1-1)
				//FileOutputStream out = new FileOutputStream("C:\\apache-tomcat-9.0.0.M15\\wtpwebapps\\RealTI_v4.0\\documentos\\requerimineto_pago_"+venta.getId()+".docx");
				FileOutputStream out = new FileOutputStream("F:\\PROYECTO JORDAN\\jasperContratos_jordan\\DESCARGAWORD\\requerimineto_pago_"+1+".docx");
				docx.write(out);
				out.close();
				System.out.println("Done");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			return null;
		}

}
