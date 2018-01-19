package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.model.place.Place;
import eseo.assoprojava.model.place.gps.GpsCoord;
import eseo.assoprojava.view.ui.MainWindow;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ActionSaveEvent extends javax.swing.AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionSaveEvent()
	{
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{	    
	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.setDialogTitle("Enregistrer...");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML File", "xml");
	    fileChooser.setFileFilter(filter);

	    fileChooser.showSaveDialog(null);
	    
		Event event = MainWindow.getInstance().getWorkPanel().getViewEvent().getEvent();
		Place place = event.getPlace();
		GpsCoord gpsCoord = place.getGpsCoord();
		List<Activity> activities = event.getActivities();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			
			final DocumentBuilder builder = factory.newDocumentBuilder();
			
			final Document document = builder.newDocument();
			
			final Element eventElement = document.createElement("Event");
			eventElement.setAttribute("name", event.getName());
			eventElement.setAttribute("clubOrganiser", event.getClubOrganiser());
			eventElement.setAttribute("numberMaximum", String.valueOf(event.getNumberMaximum()));
			eventElement.setAttribute("numberMinimum", String.valueOf(event.getNumberMinimum()));
			eventElement.setAttribute("price", String.valueOf(event.getPrice()));
			eventElement.setAttribute("dateBegin", dateFormat.format(event.getDateBegin()));
			eventElement.setAttribute("dateEnd", dateFormat.format(event.getDateEnd()));
			eventElement.setAttribute("description", event.getDescription());
			document.appendChild(eventElement);
			
			final Element placeElement = document.createElement("Place");
			placeElement.setAttribute("number", String.valueOf(place.getNumber()));
			placeElement.setAttribute("street", place.getStreet());
			placeElement.setAttribute("city", place.getCity());
			placeElement.setAttribute("country", place.getCountry());
			placeElement.setAttribute("state", place.getCountry());			
			placeElement.setAttribute("postalCode", String.valueOf(place.getPostalCode()));
			placeElement.setAttribute("name", place.getName());
			eventElement.appendChild(placeElement);
			
			final Element gpsCoordElement = document.createElement("GpsCoord");
			gpsCoordElement.setAttribute("latitude", String.valueOf(gpsCoord.getLatitude()));
			gpsCoordElement.setAttribute("longitude", String.valueOf(gpsCoord.getLongitude()));
			gpsCoordElement.setAttribute("latitudeDegree", String.valueOf(gpsCoord.getLatitudeDegree()));
			gpsCoordElement.setAttribute("latitudeMinute", String.valueOf(gpsCoord.getLatitudeMinute()));
			gpsCoordElement.setAttribute("latitudeSecond", String.valueOf(gpsCoord.getLatitudeSecond()));
			gpsCoordElement.setAttribute("longitudeDegree", String.valueOf(gpsCoord.getLongitudeDegree()));
			gpsCoordElement.setAttribute("longitudeMinute", String.valueOf(gpsCoord.getLongitudeMinute()));
			gpsCoordElement.setAttribute("longitudeSecond", String.valueOf(gpsCoord.getLongitudeSecond()));
			gpsCoordElement.setAttribute("north", String.valueOf(gpsCoord.isNorth()));
			gpsCoordElement.setAttribute("east", String.valueOf(gpsCoord.isEast()));
			placeElement.appendChild(gpsCoordElement);
			
			final Element activitiesElement = document.createElement("Activities");
			eventElement.appendChild(activitiesElement);
			
			for (int i = 0 ; i < activities.size() ; i++) {
				final Element activityElement = document.createElement("Activity");
				activityElement.setAttribute("name", activities.get(i).getName());
				activityElement.setAttribute("numberMaximum", String.valueOf(activities.get(i).getNumberMaximum()));
				activityElement.setAttribute("numberMinimum", String.valueOf(activities.get(i).getNumberMinimum()));
				activityElement.setAttribute("price", String.valueOf(activities.get(i).getPrice()));
				activityElement.setAttribute("dateBegin", dateFormat.format(activities.get(i).getDateBegin()));
				activityElement.setAttribute("dateEnd", dateFormat.format(activities.get(i).getDateEnd()));
				activityElement.setAttribute("description", activities.get(i).getDescription());
				activitiesElement.appendChild(activityElement);
				
				final Element organiserElement = document.createElement("Organiser");
				organiserElement.setAttribute("firstName", activities.get(i).getOrganiser().getFirstName());
				organiserElement.setAttribute("lastName", activities.get(i).getOrganiser().getLastName());
				organiserElement.setAttribute("club", activities.get(i).getOrganiser().getClub());
				organiserElement.setAttribute("role", activities.get(i).getOrganiser().getRole());
				activityElement.appendChild(organiserElement);
			}
			
			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
		    final Transformer transformer = transformerFactory.newTransformer();
		    final DOMSource source = new DOMSource(document);
		    final StreamResult sortie = new StreamResult(new File(fileChooser.getSelectedFile().getAbsolutePath()));
		    
		    transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");			
		    		
		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
		    transformer.transform(source, sortie);	
		}
		
		catch (final ParserConfigurationException e1) {
		    e1.printStackTrace();
		}
		
		catch (TransformerConfigurationException e1) {
		    e1.printStackTrace();
		}
		
		catch (TransformerException e1) {
		    e1.printStackTrace();
		}		
		return;
	}
}
