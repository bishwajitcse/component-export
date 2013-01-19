package org.vaadin.addon.componentexport;

import org.vaadin.addon.componentexport.java.PdfFromComponent;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class ComponentexportdemoApplication extends Application {
	private VerticalLayout all;

	@Override
	public void init() {
		Window mainWindow = new Window("Componentexportdemo Application");
		
		
		
		all = new VerticalLayout();
		Label label = new Label("Hello Vaadin user");
		
		Table table = new Table();
        for (int i=0;i<50;i++){
			table.addItem("Item nro: "+i);
		}
        
		Select s = new Select("select");
		for (int i=0;i<50;i++){
			s.addItem("Item nro: "+i);
		}
		
		TextField t = new TextField("textfield");
		t.setValue("Hola");
		
		Button b = new Button("PDF");
		
		b.addListener(new com.vaadin.ui.Button.ClickListener() {
			
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				PdfFromComponent factory = new PdfFromComponent();
				factory.export(all);
				
			}
		});

		
		all.addComponent(label);
		all.addComponent(table);
		all.addComponent(s);
		all.addComponent(t);
		all.addComponent(b);
		
		mainWindow.addComponent(all);
		setMainWindow(mainWindow);
	}

}
