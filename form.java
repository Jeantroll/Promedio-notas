import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class form extends JFrame {

	private JPanel contentPane;
	private JTextField NumEstudiantes;
	DecimalFormat formateador = new DecimalFormat("###.##");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero de estudiantes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(104, 49, 158, 14);
		contentPane.add(lblNewLabel);
		
		NumEstudiantes = new JTextField();
		NumEstudiantes.setBounds(272, 48, 86, 20);
		contentPane.add(NumEstudiantes);
		NumEstudiantes.setColumns(10);
		
		JLabel lblPromedio = new JLabel("Promedio matematicas");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPromedio.setBounds(104, 103, 158, 14);
		contentPane.add(lblPromedio);
		
		JLabel lblPromedioEspaol = new JLabel("Promedio espa\u00F1ol");
		lblPromedioEspaol.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPromedioEspaol.setBounds(104, 128, 158, 14);
		contentPane.add(lblPromedioEspaol);
		
		JLabel lblPromedioIngles = new JLabel("Promedio ingles");
		lblPromedioIngles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPromedioIngles.setBounds(104, 153, 158, 14);
		contentPane.add(lblPromedioIngles);
		
		JLabel PromMat = new JLabel("");
		PromMat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PromMat.setBounds(272, 105, 158, 14);
		contentPane.add(PromMat);
		
		JLabel PromEsp = new JLabel("");
		PromEsp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PromEsp.setBounds(272, 130, 158, 14);
		contentPane.add(PromEsp);
		
		JLabel PromIng = new JLabel("");
		PromIng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PromIng.setBounds(272, 155, 158, 14);
		contentPane.add(PromIng);
		
		JButton btnNewButton = new JButton("INGRESAR CALIFICACIONES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidadEstudiantes = Integer.parseInt(NumEstudiantes.getText());
				int i=0;
				double cal=0;
				double sum=0;
				double prom=0;
				String formateadoPromedio ="";
				String calificacion="";
				
				Object[] posibilidades = {"Matematicas","Español","Ingles"};
				String materia=(String)JOptionPane.showInputDialog(null,"Materias","Seleccion de materia",JOptionPane.QUESTION_MESSAGE,null,posibilidades,"Matematicas");
				switch(materia) {
				
				case "Matematica":
					for(i=1;i<=cantidadEstudiantes;i++) {
						calificacion=JOptionPane.showInputDialog(null,"Califiación"+i);
						cal = Double.parseDouble(calificacion);
						sum+=cal;
					}
					prom= sum/cantidadEstudiantes;
					formateadoPromedio = formateador.format(prom);
					PromMat.setText(String.valueOf(formateadoPromedio));
					break;
				case "Español":
					i=1;
					while(i<=cantidadEstudiantes) {
						calificacion = JOptionPane.showInputDialog(null, "Calificacion", +i);
						cal = Double.parseDouble(calificacion);
						sum+=cal;
						i++;
					}
					prom = sum/cantidadEstudiantes;
					formateadoPromedio=formateador.format(prom);
					PromEsp.setText(String.valueOf(formateadoPromedio));
					break;
					
				case "Ingles":
					i=1;
					do {
						calificacion = JOptionPane.showInputDialog(null,"Calificación",+i);
						cal = Double.parseDouble(califiacion);
						sum+=cal;
						i++;
					while(i<=cantidadEstudiantes) {
							
							prom= sum/cantidadEstudiantes;
							formateadoPromedio = formateador.format(prom);
							PromIng.setText(String.valueOf(formateadoPromedio));
							
		
					}
					}
				
			}}
		});
		btnNewButton.setBounds(218, 293, 179, 23);
		contentPane.add(btnNewButton);
	}
}
