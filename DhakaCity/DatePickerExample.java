package DhakaCity;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class DatePickerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Date Picker Example");
        JPanel p = new JPanel();

        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

        JButton showDateButton = new JButton("Show Selected Date");

        showDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date selectedDate = (Date) model.getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String selectedDateString = dateFormat.format(selectedDate);
                JOptionPane.showMessageDialog(frame, "Selected Date: " + selectedDateString);
            }
        });

        p.setLayout(null);
        datePicker.setBounds(120, 314, 370, 30);
        showDateButton.setBounds(120, 354, 200, 30);
        p.add(datePicker);
        p.add(showDateButton);

        frame.add(p);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static class DateComponentFormatter extends JFormattedTextField.AbstractFormatter {
        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) {
            try {
                return dateFormatter.parseObject(text);
            } catch (java.text.ParseException e) {
                return null;
            }
        }

        @Override
        public String valueToString(Object value) {
            if (value != null) {
                return dateFormatter.format(value);
            }
            return "";
        }
    }
}

