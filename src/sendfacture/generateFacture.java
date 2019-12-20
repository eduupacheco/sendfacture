package sendfacture;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import sun.applet.Main;

public class generateFacture {

    public generateFacture(windowMain w, String facture_name, String facture_code,
            String name, String logo_rute, String address, String city, String postal_code, String phone_number,
            String customer_name, String customer_city, String customer_postalcode, String customer_address, String customer_phonenumber, String customer_email,
            JTable tabledata, String totalprice) {

        File rute = new File(w.RUTE_FACTURES + (facture_name + facture_code).toUpperCase() + ".pdf");

        try {
            w.setEnabled(false);
            
            // DOCUMENT PROPERTIES
            Document facture = new Document() {};
            PdfWriter.getInstance(facture, new FileOutputStream(rute));

            facture.open();

            // FACTURE DATA
            addLogo(facture, w.RUTE_MY_LOGO_FOLDER+logo_rute);
            addEnterpriseInfo(facture, name, address, city, postal_code, phone_number);
            addCustomerInfo(facture, customer_name, customer_address, customer_city, customer_postalcode, customer_phonenumber, customer_email);
            addDate(facture);
            facture.add(addTable(tabledata, totalprice));
            addEmptyLine(new Paragraph(), 2);
            addDataFacture(facture, facture_name, facture_code);

            facture.close();
            w.setEnabled(true);
            w.setShowAlert("Facture generated.", 1);
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Se ha producido un error al generar la factura.", "", JOptionPane.ERROR_MESSAGE);
            w.setEnabled(true);
        }
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private void addLogo(Document facture, String logo) throws DocumentException {
        try {
            Image companyLogo = Image.getInstance(logo);
            companyLogo.setAbsolutePosition(420, 735);
            companyLogo.scalePercent(12);
            facture.add(companyLogo);
        } catch (DocumentException dex) {
        } catch (IOException ex) {
        }
    }

    private void addEnterpriseInfo(Document facture, String name, String address, String city, String postalcode, String phonenumber) throws DocumentException {
        Paragraph enterprisename = new Paragraph();
        enterprisename.add(name);
        enterprisename.setAlignment(Element.ALIGN_LEFT);
        facture.add(enterprisename);

        Paragraph enterpriseinfo = new Paragraph();
        enterpriseinfo.add(
                address + "\n"
                + city + "\n"
                + postalcode + "\n"
                + phonenumber + "\n");

        enterpriseinfo.setAlignment(Element.ALIGN_LEFT);
        addEmptyLine(enterpriseinfo, 2);
        facture.add(enterpriseinfo);
    }

    private void addCustomerInfo(Document facture, String name, String address, String city, String postalcode, String phonenumber, String email) throws DocumentException {
        Paragraph customerinfo = new Paragraph();
        customerinfo.add(name + "\n"
                + address + "\n"
                + city + "\n"
                + postalcode + "\n"
                + phonenumber + "\n"
                + email + "\n");

        customerinfo.setAlignment(Element.ALIGN_RIGHT);
        addEmptyLine(customerinfo, 2);
        facture.add(customerinfo);
    }

    public PdfPTable addTable(JTable tabledata, String totalprice) throws DocumentException {

        DecimalFormat df = new DecimalFormat("0.00");
        PdfPTable table = new PdfPTable(4);
        table.setTotalWidth(new float[]{270, 80, 80, 90});
        table.setLockedWidth(true);

        PdfPCell cell;
        cell = new PdfPCell(new Phrase("DESCRIPCIÓN"));
        cell.setColspan(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("PRECIO"));
        cell.setColspan(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("CANTIDAD"));
        cell.setColspan(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("IMPORTE"));
        cell.setColspan(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        table.addCell(cell);

        table.setHeaderRows(1);

        for (int row = 0; row < tabledata.getRowCount(); row++) {
            table.addCell("" + tabledata.getValueAt(row, 0));
            table.addCell("" + tabledata.getValueAt(row, 1) + "€");
            table.addCell("" + tabledata.getValueAt(row, 2));
            table.addCell("" + tabledata.getValueAt(row, 3) + "€");
        }

        cell = new PdfPCell();
        table.addCell(cell).setBackgroundColor(BaseColor.DARK_GRAY);
        table.addCell(cell).setBackgroundColor(BaseColor.DARK_GRAY);
        table.addCell("TOTAL");
        table.addCell(totalprice);

        return table;
    }

    private void addDataFacture(Document facture, String facturename, String facturecode) throws DocumentException {
        Paragraph datafacture = new Paragraph();
        datafacture.add(facturecode);
        datafacture.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(datafacture, 2);
        facture.add(datafacture);
    }

    private void addDate(Document facture) throws DocumentException {
        Calendar c = Calendar.getInstance();
        String day = Integer.toString(c.get(Calendar.DATE));
        String month = Integer.toString(c.get(Calendar.MONTH));
        String year = Integer.toString(c.get(Calendar.YEAR));
        String date = "FECHA: " + day + "-" + month + "-" + year;
        Paragraph datespace = new Paragraph();
        datespace.add(date);
        addEmptyLine(datespace, 1);
        facture.add(datespace);
    }
}
