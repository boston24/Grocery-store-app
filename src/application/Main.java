package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Main extends Application {
		
	TableView<Product> table;
		
	GridPane windowMenu = new GridPane();
	GridPane windowProducts = new GridPane();
		
	public void start(Stage stage) {
		
		
		windowMenu.setId("titleScreen");
		windowMenu.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		
		stage.setResizable(false);

		Scene sceneMenu = new Scene(windowMenu,600,600);
		Scene sceneProducts = new Scene(windowProducts,600,800);
		stage.setTitle("Sklep na rogu");
		
		windowProducts.setId("productsScreen");
		windowProducts.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		
		windowProducts.setPadding(new Insets(10,10,10,10));
		windowProducts.setVgap(10);
		
		Button browse = new Button("Produkty");
		browse.setOnAction(Browse -> {
			stage.setScene(sceneProducts);
			stage.setTitle("Produkty");
			stage.show();
			});
		
		Button exit = new Button("Wyjscie");
		exit.setOnAction(Exit->{stage.close();});
		
		VBox blank = new VBox();
		blank.setPrefHeight(300);
		blank.setPrefWidth(600);
		windowMenu.add(blank,0,0,1,1);
		
		
		VBox top = new VBox();
		top.setAlignment(Pos.BASELINE_CENTER);
		top.setPrefWidth(300);
		top.setPrefHeight(600);
		//top.setPadding(new Insets(50,50,50,50));
		top.setSpacing(50);
		top.getChildren().addAll(browse,exit);
		windowMenu.add(top, 0,1,1,1);

		/////////////KONIEC MENU////////////////////////////////
		
		ObservableList<Product> products = FXCollections.observableArrayList();
		
		//Name column
		TableColumn<Product, String> nameColumn = new TableColumn<>("Nazwa");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		//Price column
		TableColumn<Product, Double> priceColumn = new TableColumn<>("Cena (z³)");
		priceColumn.setMinWidth(115);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		//Quantity in cart
		TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Iloœæ");
		quantityColumn.setMinWidth(115);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("numInCart"));
		
		//Price * quantity
		TableColumn<Product, Double> priceSumColumn = new TableColumn<>("L¹cznie (z³)");
		priceSumColumn.setMinWidth(115);
		priceSumColumn.setCellValueFactory(new PropertyValueFactory<>("priceSum"));
		
		Label wK = new Label ("Wartoœæ koszyka: "+wartoscKoszyka(products));
		
		Product d1 = new Diary("Twaróg",3.50,3,1,250);
		Product d2 = new Diary("Mleko 3.2%",2.00,100,1,500);
		Product d3 = new Diary("Ser gouda",10.00,80,1,500);
		Product d4 = new Diary("Jogurt",1.50,160,1,150);
		Product d5 = new Diary("Jaja",5.50,20,1,100);
		
		Product b1 = new Beverages("Coca-Cola",5.50,24,1,2.25);
		Product b2 = new Beverages("Sok",4.0,30,1,1);
		Product b3 = new Beverages("Woda NGZ ",0.50,20,1,500);
		Product b4 = new Beverages("Fanta",3.50,8,1,1.5);
		Product b5 = new Beverages("Sprite",3.50,20,1,1.5);
		
		Product s1 = new Snacks("Lay's",5.00,100,1,250);
		Product s2 = new Snacks("Snickers",2.00,36,1,500);
		Product s3 = new Snacks("¯elki Haribo",4.00,10,1,500);
		Product s4 = new Snacks("Krakersy",2.50,24,1,150);
		Product s5 = new Snacks("Wafle",5.50,4,1,100);
		
		///////////////DIARY//////////////////
		
		Button nab1 = new Button(d1.getName()+"\n"+d1.getQuantity()+" szt.");
		nab1.setOnAction(e -> {
			addToCart(d1,products,nab1);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		
		nab1.setPrefHeight(100);
		nab1.setPrefWidth(100);
		
		Button nab2 = new Button(d2.getName()+"\n"+d2.getQuantity()+" szt.");
		nab2.setOnAction(e -> {
			addToCart(d2,products,nab2);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		nab2.setPrefHeight(100);
		nab2.setPrefWidth(100);
		
		Button nab3 = new Button(d3.getName()+"\n"+d3.getQuantity()+" szt.");
		nab3.setOnAction(e -> {
			addToCart(d3,products,nab3);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		nab3.setPrefHeight(100);
		nab3.setPrefWidth(100);
		
		Button nab4 = new Button(d4.getName()+"\n"+d4.getQuantity()+" szt.");
		nab4.setOnAction(e -> {
			addToCart(d4,products,nab4);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		nab4.setPrefHeight(100);
		nab4.setPrefWidth(100);

		Button nab5 = new Button(d5.getName()+"\n"+d5.getQuantity()+" szt.");
		nab5.setOnAction(e -> {
			addToCart(d5,products,nab5);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		nab5.setPrefHeight(100);
		nab5.setPrefWidth(100);
		
		///////////////BEVERAGES///////////////////////////
		
		Button bev1 = new Button(b1.getName()+"\n"+b1.getQuantity()+" szt.");
		bev1.setOnAction(e -> {
			addToCart(b1,products,bev1);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		
		bev1.setPrefHeight(100);
		bev1.setPrefWidth(100);
		
		Button bev2 = new Button(b2.getName()+"\n"+b2.getQuantity()+" szt.");
		bev2.setOnAction(e -> {
			addToCart(b2,products,bev2);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		bev2.setPrefHeight(100);
		bev2.setPrefWidth(100);
		
		Button bev3 = new Button(b3.getName()+"\n"+b3.getQuantity()+" szt.");
		bev3.setOnAction(e -> {
			addToCart(b3,products,bev3);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		bev3.setPrefHeight(100);
		bev3.setPrefWidth(100);
		
		Button bev4 = new Button(b4.getName()+"\n"+b4.getQuantity()+" szt.");
		bev4.setOnAction(e -> {
			addToCart(b4,products,bev4);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		bev4.setPrefHeight(100);
		bev4.setPrefWidth(100);

		Button bev5 = new Button(b5.getName()+"\n"+b5.getQuantity()+" szt.");
		bev5.setOnAction(e -> {
			addToCart(b5,products,bev5);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		bev5.setPrefHeight(100);
		bev5.setPrefWidth(100);
		
		//////////////////SNACKS//////////////////
		
		Button snac1 = new Button(s1.getName()+"\n"+s1.getQuantity()+" szt.");
		snac1.setOnAction(e -> {
			addToCart(s1,products,snac1);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		
		snac1.setPrefHeight(100);
		snac1.setPrefWidth(100);
		
		Button snac2 = new Button(s2.getName()+"\n"+s2.getQuantity()+" szt.");
		snac2.setOnAction(e -> {
			addToCart(s2,products,snac2);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		snac2.setPrefHeight(100);
		snac2.setPrefWidth(100);
		
		Button snac3 = new Button(s3.getName()+"\n"+s3.getQuantity()+" szt.");
		snac3.setOnAction(e -> {
			addToCart(s3,products,snac3);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		snac3.setPrefHeight(100);
		snac3.setPrefWidth(100);
		
		Button snac4 = new Button(s4.getName()+"\n"+s4.getQuantity()+" szt.");
		snac4.setOnAction(e -> {
			addToCart(s4,products,snac4);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		snac4.setPrefHeight(100);
		snac4.setPrefWidth(100);

		Button snac5 = new Button(s5.getName()+"\n"+s5.getQuantity()+" szt.");
		snac5.setOnAction(e -> {
			addToCart(s5,products,snac5);
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			table.refresh();
		});
		snac5.setPrefHeight(100);
		snac5.setPrefWidth(100);
		
		/////////////////////////////////////////////////////////////////////////////////////////	
		
		Button back = new Button();
		back.setId("wstecz");
		back.setMaxSize(100, 100);
		back.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		
		back.setOnAction(Back -> {
			stage.setScene(sceneMenu);
			stage.setTitle("Menu");
			stage.show();
		});
		
		TextField nazwa = new TextField();
		nazwa.setPromptText("Nazwa");
		TextField ilosc = new TextField();
		ilosc.setPromptText("Ilosc");
		
		Button usunAll = new Button("Usuñ koszyk");
		usunAll.setOnAction(e -> {
			for(Product wartosc:products) {
				wartosc.setQuantity(wartosc.getQuantity()+wartosc.getNumInCart());
				wartosc.setNumInCart(1);
			}
			
			////////////////UAKTUALNIENIE PRZYCISKOW//////////////////////////////////////////
			
			nab1.setText(d1.getName()+"\n"+d1.getQuantity()+" szt.");
			if(d1.getQuantity()>0) nab1.setDisable(false);
			
			nab2.setText(d2.getName()+"\n"+d2.getQuantity()+" szt.");
			if(d2.getQuantity()>0) nab2.setDisable(false);
			
			nab3.setText(d3.getName()+"\n"+d3.getQuantity()+" szt.");
			if(d3.getQuantity()>0) nab3.setDisable(false);
			
			nab4.setText(d4.getName()+"\n"+d4.getQuantity()+" szt.");
			if(d4.getQuantity()>0) nab4.setDisable(false);
			
			nab5.setText(d5.getName()+"\n"+d5.getQuantity()+" szt.");
			if(d5.getQuantity()>0) nab5.setDisable(false);
			
			
			bev1.setText(b1.getName()+"\n"+b1.getQuantity()+" szt.");
			if(b1.getQuantity()>0) bev1.setDisable(false);
			
			bev2.setText(b2.getName()+"\n"+b2.getQuantity()+" szt.");
			if(b2.getQuantity()>0) bev2.setDisable(false);
			
			bev3.setText(b3.getName()+"\n"+b3.getQuantity()+" szt.");
			if(b3.getQuantity()>0) bev3.setDisable(false);
			
			bev4.setText(b4.getName()+"\n"+b4.getQuantity()+" szt.");
			if(b4.getQuantity()>0) bev4.setDisable(false);
			
			bev5.setText(b5.getName()+"\n"+b5.getQuantity()+" szt.");
			if(b5.getQuantity()>0) bev5.setDisable(false);
			
			
			snac1.setText(s1.getName()+"\n"+s1.getQuantity()+" szt.");
			if(s1.getQuantity()>0) snac1.setDisable(false);
			
			snac2.setText(s2.getName()+"\n"+s2.getQuantity()+" szt.");
			if(s2.getQuantity()>0) snac2.setDisable(false);
			
			snac3.setText(s3.getName()+"\n"+s3.getQuantity()+" szt.");
			if(s3.getQuantity()>0) snac3.setDisable(false);
			
			snac4.setText(s4.getName()+"\n"+s4.getQuantity()+" szt.");
			if(s4.getQuantity()>0) snac4.setDisable(false);
			
			snac5.setText(s5.getName()+"\n"+s5.getQuantity()+" szt.");
			if(s5.getQuantity()>0) snac5.setDisable(false);
			
			////////////////////////////////////////////////////////////////////////
			
			table.getItems().clear();
			table.refresh();
			
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
			
			
		});
		
		Button usun = new Button("Usuñ");
		usun.setOnAction(e -> {
			
			int num = Integer.parseInt(ilosc.getText());
			
			if(!nazwa.getText().isEmpty() && !ilosc.getText().isEmpty()) {
				
			
			for (Product wartosc:products) {
				if(nazwa.getText().equals(wartosc.getName())) {
					if(num >= wartosc.getNumInCart()) {
						
						wartosc.setQuantity(wartosc.getQuantity()+wartosc.getNumInCart());
						wartosc.setNumInCart(1);
						products.remove(wartosc);
						table.refresh();
					}
					else {
						wartosc.setQuantity(wartosc.getQuantity()+num);
						wartosc.setNumInCart(wartosc.getNumInCart()-num);
						products.add(wartosc);
						products.remove(wartosc);;
						table.refresh();
					}
					
					////////////////UAKTUALNIENIE PRZYCISKOW//////////////////////////////////////////
					
					nab1.setText(d1.getName()+"\n"+d1.getQuantity()+" szt.");
					if(d1.getQuantity()>0) nab1.setDisable(false);
					
					nab2.setText(d2.getName()+"\n"+d2.getQuantity()+" szt.");
					if(d2.getQuantity()>0) nab2.setDisable(false);
					
					nab3.setText(d3.getName()+"\n"+d3.getQuantity()+" szt.");
					if(d3.getQuantity()>0) nab3.setDisable(false);
					
					nab4.setText(d4.getName()+"\n"+d4.getQuantity()+" szt.");
					if(d4.getQuantity()>0) nab4.setDisable(false);
					
					nab5.setText(d5.getName()+"\n"+d5.getQuantity()+" szt.");
					if(d5.getQuantity()>0) nab5.setDisable(false);
					
					
					bev1.setText(b1.getName()+"\n"+b1.getQuantity()+" szt.");
					if(b1.getQuantity()>0) bev1.setDisable(false);
					
					bev2.setText(b2.getName()+"\n"+b2.getQuantity()+" szt.");
					if(b2.getQuantity()>0) bev2.setDisable(false);
					
					bev3.setText(b3.getName()+"\n"+b3.getQuantity()+" szt.");
					if(b3.getQuantity()>0) bev3.setDisable(false);
					
					bev4.setText(b4.getName()+"\n"+b4.getQuantity()+" szt.");
					if(b4.getQuantity()>0) bev4.setDisable(false);
					
					bev5.setText(b5.getName()+"\n"+b5.getQuantity()+" szt.");
					if(b5.getQuantity()>0) bev5.setDisable(false);
					
					
					snac1.setText(s1.getName()+"\n"+s1.getQuantity()+" szt.");
					if(s1.getQuantity()>0) snac1.setDisable(false);
					
					snac2.setText(s2.getName()+"\n"+s2.getQuantity()+" szt.");
					if(s2.getQuantity()>0) snac2.setDisable(false);
					
					snac3.setText(s3.getName()+"\n"+s3.getQuantity()+" szt.");
					if(s3.getQuantity()>0) snac3.setDisable(false);
					
					snac4.setText(s4.getName()+"\n"+s4.getQuantity()+" szt.");
					if(s4.getQuantity()>0) snac4.setDisable(false);
					
					snac5.setText(s5.getName()+"\n"+s5.getQuantity()+" szt.");
					if(s5.getQuantity()>0) snac5.setDisable(false);
					
					////////////////////////////////////////////////////////////////////////
				
				}
			}

			}
			wK.setText("Wartoœæ koszyka: "+wartoscKoszyka(products)+" z³");
		});
		
		windowProducts.add(wK, 1, 0,2,1);
		
		nazwa.setPrefWidth(100);
		ilosc.setPrefWidth(100);
		usun.setPrefWidth(100);
		usunAll.setPrefWidth(150);
		
		windowProducts.add(nazwa, 0, 9,1,1);
		windowProducts.add(ilosc, 1, 9,1,1);
		windowProducts.add(usun, 2, 9,1,1);
		windowProducts.add(usunAll, 3, 9,2,1);
		
		
		table = new TableView<>();
		table.setItems(products);
		table.getColumns().addAll(nameColumn,priceColumn,quantityColumn,priceSumColumn);
		table.setPlaceholder(new Label("Koszyk jest pusty"));
		
		Button pay = new Button("Zap³aæ");
		pay.setMinWidth(100);
		windowProducts.add(pay, 4, 0,1,1);
		
		windowProducts.setHgap(10);
		windowProducts.setPadding(new Insets(25,25,25,25));
		
		windowProducts.add(back,0,0,1,1);
		
		windowProducts.add(nab1,0,4,1,1);
		windowProducts.add(nab2,1,4,1,1);
		windowProducts.add(nab3,2,4,1,1);
		windowProducts.add(nab4,3,4,1,1);
		windowProducts.add(nab5,4,4,1,1);
		
		windowProducts.add(bev1,0,5,1,1);
		windowProducts.add(bev2,1,5,1,1);
		windowProducts.add(bev3,2,5,1,1);
		windowProducts.add(bev4,3,5,1,1);
		windowProducts.add(bev5,4,5,1,1);
		
		windowProducts.add(snac1,0,6,1,1);
		windowProducts.add(snac2,1,6,1,1);
		windowProducts.add(snac3,2,6,1,1);
		windowProducts.add(snac4,3,6,1,1);
		windowProducts.add(snac5,4,6,1,1);
		

		VBox koszyk = new VBox();
		koszyk.getChildren().addAll(table);
		windowProducts.add(koszyk,0,8,5,1);
		
		stage.setScene(sceneMenu);
		stage.show();
		
		
	}
	
	public void addToCart(Product p, ObservableList<Product> l, Button b) {
		
		int x = 0;
		for (Product wartosc:l) {
			if(wartosc.getName() == p.getName()) x=1;
		}
		if(x==0) {
			l.add(p);
			p.setQuantity(p.getQuantity()-1);
		}
		if(x==1) {
			l.remove(p);
			p.setNumInCart(p.getNumInCart()+1);
			p.setQuantity(p.getQuantity()-1);
			l.add(p);
		}
		b.setText(p.getName()+"\n"+p.getQuantity()+" szt.");
		if(p.getQuantity()==0) b.setDisable(true);
		
	}
	
	public double wartoscKoszyka(ObservableList<Product> l) {
		double s=0;
		for(Product wartosc:l) {
			s+=wartosc.getPriceSum();
		}
		return s;
	}
	
	public static void main(String[] args) {
		
		launch(args);

	}

}
