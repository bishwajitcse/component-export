package org.vaadin.addon.componentexport;

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
		table .setWidth("100%");
        table.setHeight("170px");

        // selectable
        table.setSelectable(true);
        table.setMultiSelect(true);
        table.setImmediate(true); // react at once when something is selected

        table.setHeight("170px");

		
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

		
		all.addComponent(label);
		all.addComponent(table);
		all.addComponent(s);
		all.addComponent(t);
		all.addComponent(b);

		
		b.addListener(new com.vaadin.ui.Button.ClickListener() {
			
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				org.vaadin.addon.componentexport.java.PdfFromComponent factory = new org.vaadin.addon.componentexport.java.PdfFromComponent();
				factory.export(all);
				
			}
		});

		
		mainWindow.addComponent(all);
		setMainWindow(mainWindow);
	}

}
