package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import pointOffSale.ProductCollection;
import pointOffSale.Product;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;


public class Panel extends JPanel {
	//collection will hold products
	private ProductCollection collection;
	private ProductCollection cart;
	//constant width and height of this panel
	private final int WIDTH = 900, HEIGHT = 600;

	//starting check boxes
	private JCheckBox butcher;
	private JCheckBox fruit_and_veg;
	private JCheckBox deli;
	private JCheckBox kitchen_supplies;
	private JLabel lblDepartments;
	private JTextField textField;


	public Panel() {
		//starting main panel
		collection = new ProductCollection("./data.txt");
		cart = new ProductCollection();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);

		//beginning textPane for collection contents
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Items", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(172, 127, 377, 193);
		add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 371, 177);
		panel_1.add(scrollPane);
		panel_1.setBackground(Color.LIGHT_GRAY);

		JTextPane textPane_items = new JTextPane();
		scrollPane.setViewportView(textPane_items);
		textPane_items.setText(collection.toString());
		//ending textPane for collection 

		//starting textPane for suggestions
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Similar Items", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(172, 331, 377, 145);
		add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);

		JTextPane textPane_similarItems = new JTextPane();
		textPane_similarItems.setBounds(6, 16, 365, 115);
		panel_2.add(textPane_similarItems);
		//ending textPane for suggestions

		//starting list for cart
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cart", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(560, 127, 261, 352);
		add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		
		JTextArea textArea_cart = new JTextArea();
		textArea_cart.setBounds(10, 21, 241, 320);
		panel.add(textArea_cart);
		//ending list for cart
		
		//beginning total price
		JTextPane textPane_price = new JTextPane();
		textPane_price.setBounds(707, 490, 100, 28);
		add(textPane_price);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(663, 490, 69, 28);
		add(lblTotal);
		//ending total price

		//starting checkBoxes for categories
		butcher = new JCheckBox("Butcher");
		butcher.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//next block checks if the button is checked
				//if it is, it will show the category of the checked button
				if (butcher.isSelected()) {
					ArrayList<Product> butcher = collection.retrieveCollection("meat");
					String butcherStr = "";
					for (Product product : butcher) {
						butcherStr += product.toString() + "\n";
					}
					textPane_items.setText(butcherStr);
				}
				//when not checked, it will set the textPane back to the collection
				else {
					textPane_items.setText(collection.toString());
				}
			}
		});
		butcher.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		butcher.setBounds(25, 196, 120, 23);
		add(butcher);
		butcher.setBackground(Color.LIGHT_GRAY);
		
		fruit_and_veg = new JCheckBox("Fruit");
		fruit_and_veg.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//next block checks if the button is checked
				//if it is, it will show the category of the checked button
				if (fruit_and_veg.isSelected()) {
					ArrayList<Product> fruitVeg = collection.retrieveCollection("fruit");
					String fruitStr = "";
					for (Product product : fruitVeg) {
						fruitStr += product.toString() + "\n";
					}
					textPane_items.setText(fruitStr);
				}
				//when not checked, it will set the textPane back to the collection
				else {
					textPane_items.setText(collection.toString());
				}
			}
		});
		fruit_and_veg.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		fruit_and_veg.setBounds(25, 222, 137, 23);
		add(fruit_and_veg);
		fruit_and_veg.setBackground(Color.LIGHT_GRAY);
	
		deli = new JCheckBox("Deli");
		deli.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//next block checks if the button is checked
				//if it is, it will show the category of the checked button
				if (deli.isSelected()) {
					ArrayList<Product> deli = collection.retrieveCollection("deli");
					String deliStr = "";
					for (Product product : deli) {
						deliStr += product.toString() + "\n";
					}
					textPane_items.setText(deliStr);
				}
				//when not checked, it will set the textPane back to the collection
				else {
					textPane_items.setText(collection.toString());
				}
			}
		});
		deli.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		deli.setBounds(25, 248, 120, 23);
		add(deli);
		deli.setBackground(Color.LIGHT_GRAY);
		

		kitchen_supplies = new JCheckBox("Kitchen Supplies");
		kitchen_supplies.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//next block checks if the button is checked
				//if it is, it will show the category of the checked button
				if (kitchen_supplies.isSelected()) {
					ArrayList<Product> kitchsuppl = collection.retrieveCollection("kitchen");
					String kitchsupplStr = "";
					for (Product product : kitchsuppl) {
						kitchsupplStr += product.toString() + "\n";
					}
					textPane_items.setText(kitchsupplStr);
				}
				//when not checked, it will set the textPane back to the collection
				else {
					textPane_items.setText(collection.toString());
				}
			}
		});
		kitchen_supplies.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		kitchen_supplies.setBounds(25, 274, 153, 23);
		add(kitchen_supplies);
		kitchen_supplies.setBackground(Color.LIGHT_GRAY);
		
		JCheckBox vegetables = new JCheckBox("Vegetables");
		vegetables.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//next block checks if the button is checked
				//if it is, it will show the category of the checked button
				if (vegetables.isSelected()) {
					ArrayList<Product> veg = collection.retrieveCollection("vegetable");
					String vegStr = "";
					for (Product product : veg) {
						vegStr += product.toString() + "\n";
					}
					textPane_items.setText(vegStr);
				}
				//when not checked, it will set the textPane back to the collection
				else {
					textPane_items.setText(collection.toString());
				}
			}
		});
		vegetables.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		vegetables.setBounds(25, 297, 97, 23);
		add(vegetables);
		vegetables.setBackground(Color.LIGHT_GRAY);
		//ending checkBoxes for categories

		//beginning comboBox
		JComboBox comboBox = new JComboBox();
		ArrayList<String> products = collection.getNames();
		//dynamically fills in the combo box with products in the data.txt 
		comboBox.setModel(new DefaultComboBoxModel(products.toArray()));
		comboBox.setBounds(172, 77, 271, 39);
		add(comboBox);

		comboBox.addActionListener(new ActionListener() {
			//actionPerformed listens for the combo box to be changed
			//when box is changed, the textPane will be updated to show the product that is selected or the entire collection
			public void actionPerformed(ActionEvent e) {
				//fills the textPane_items with the selected product
				//since category is not defined, it will not generate similar items
				ArrayList<Product> product = collection.productSuggestion((String) comboBox.getSelectedItem());
				String productStr = "";
				for (Product temp : product) {
					productStr += product.toString() + "\n";
				}
				textPane_items.setText(productStr);	
				
				//assigns p to the selection in the comboBox
				Product p = collection.retrieveProduct(comboBox.getSelectedItem().toString());
				//fills the textPane_similarItems with items of the same category 
				textPane_similarItems.setText(collection.retrieveCollection(p.get_productCategory()).toString());
			}
		});
		//end comboBox

		//beginning button to clear entry from comboBox
		JButton btnClearSelection = new JButton("Clear Selection");
		btnClearSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//when clicked, comboBox will be set to default value
				comboBox.setSelectedIndex(0);
				//textPane will be set to default value as well
				textPane_items.setText(collection.toString());
				//clear the similar items pane
				textPane_similarItems.setText("");
			}
		});
		btnClearSelection.setBounds(454, 77, 120, 39);
		add(btnClearSelection);
		//ending the clear button functionality

		lblDepartments = new JLabel("Departments");
		lblDepartments.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblDepartments.setBounds(25, 166, 137, 23);
		add(lblDepartments);

		JLabel lblNicksGrocer = new JLabel("Le Store");
		lblNicksGrocer.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblNicksGrocer.setBounds(10, 11, 248, 55);
		add(lblNicksGrocer);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(232, 507, 55, 20);
		add(spinner);

		JLabel lblQuantity = new JLabel("Quantity: ");
		lblQuantity.setBounds(172, 503, 69, 28);
		add(lblQuantity);

		//button to add selected comboBox component to JList
		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//quantity holds the value that the spinner holds
				int quantity = (int) spinner.getValue();
				for (int i = 0; i < quantity; i++) {
					//adds the product to the cart as many times as is declared in the spinner (quantity)
					cart.addProduct(collection.retrieveProduct(Integer.parseInt(textField.getText())));
				}
				//changes the text area to reflect what is in the cart
				textArea_cart.setText(cart.toString());
				//updates the quantity in the main collection
				collection.productUpdate(Integer.parseInt(textField.getText()), quantity);
				
				//changes the total price
				textPane_price.setText(cart.returnTotal());
			}
		});
		btnAddToCart.setBounds(323, 487, 120, 39);
		add(btnAddToCart);
		//ending button to add to cart
		
		//radio button to change to "dark mode"
		JRadioButton rdbtnDarkMode = new JRadioButton("Dark Mode");
		rdbtnDarkMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnDarkMode.isSelected()) {
					setBackground(Color.GRAY);
					panel.setBackground(Color.GRAY);
					panel_1.setBackground(Color.GRAY);
					panel_2.setBackground(Color.GRAY);
					butcher.setBackground(Color.GRAY);
					fruit_and_veg.setBackground(Color.GRAY);
					kitchen_supplies.setBackground(Color.GRAY);
					deli.setBackground(Color.GRAY);
					rdbtnDarkMode.setBackground(Color.GRAY);
				}
				else {
					setBackground(Color.LIGHT_GRAY);
					panel.setBackground(Color.LIGHT_GRAY);
					panel_1.setBackground(Color.LIGHT_GRAY);
					panel_2.setBackground(Color.LIGHT_GRAY);
					butcher.setBackground(Color.LIGHT_GRAY);
					fruit_and_veg.setBackground(Color.LIGHT_GRAY);
					kitchen_supplies.setBackground(Color.LIGHT_GRAY);
					deli.setBackground(Color.LIGHT_GRAY);
					rdbtnDarkMode.setBackground(Color.LIGHT_GRAY);
				}
			}
		});
		rdbtnDarkMode.setBounds(10, 570, 109, 23);
		add(rdbtnDarkMode);
		rdbtnDarkMode.setBackground(Color.LIGHT_GRAY);
		//ending radio button
		
		textField = new JTextField();
		textField.setBounds(232, 482, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		lblProductId.setBounds(172, 487, 86, 14);
		add(lblProductId);
		
		//starting button to remove from cart
		JButton btnRemoveFromCart = new JButton("Remove from Cart");
		btnRemoveFromCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//functionality to remove an item from the cart
				int quantity = (int) spinner.getValue();

				for (int i = 0; i < quantity; i++) {
					//removes the product from the cart as many times as is declared in the spinner (quantity)
					cart.removeProduct(Integer.parseInt(textField.getText()));
				}
				//changes the text area to reflect what is in the cart
				textArea_cart.setText(cart.toString());

				//changes the total price
				textPane_price.setText(cart.returnTotal());
			}
		});
		btnRemoveFromCart.setBounds(454, 487, 143, 40);
		add(btnRemoveFromCart);
		//ending button to remove from cart
	}

	//writes to file upon closing window
	public void doClose() {
		collection.writeFile("./data.txt");
	}
}
