package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.activity.organiser.Organiser;
import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.model.event.place.Place;
import eseo.assoprojava.model.event.place.gps.GpsCoord;
import eseo.assoprojava.view.ui.MainWindow;

/**
 * 
 * @author Suline
 * @version 1.0
 *
 */
public class ActionLoadEvent extends javax.swing.AbstractAction {

	private static final long serialVersionUID = 1L;

	/**
	 * Create an action to load XML file
	 */
	public ActionLoadEvent()
	{
		super();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		loadEvent();
	}
	
	/**
	 * Load XML file from a chosen folder
	 */
	private void loadEvent()
	{
		// Chose the XML file from the file explorer
		JFileChooser dialogue = new JFileChooser();
		// Filter by XML File
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML File", "xml");
		dialogue.setFileFilter(filter);
		dialogue.showOpenDialog(null);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Event event = new Event();
		Place place = new Place();
		Activity activity = new Activity();
		Organiser organiser = new Organiser();
		// Chose date format
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			File fileXML = dialogue.getSelectedFile();

			Document xml = builder.parse(fileXML);
			// Add  the event
			Element root = xml.getDocumentElement();
			event.setName(root.getAttribute("name"));
			event.setClubOrganiser(root.getAttribute("clubOrganiser"));
			event.setNumberMaximum(Integer.parseInt(root.getAttribute("numberMaximum")));
			event.setNumberMinimum(Integer.parseInt(root.getAttribute("numberMinimum")));
			event.setPrice(Double.parseDouble(root.getAttribute("price")));
			event.setDateBegin(dateFormat.parse(root.getAttribute("dateBegin")));
			event.setDateEnd(dateFormat.parse(root.getAttribute("dateEnd")));
			event.setDescription(root.getAttribute("description"));
			
			// Get event parameters
			NodeList rootNodes = root.getChildNodes();
			int nbRootNode = rootNodes.getLength();
			for (int i = 0; i < nbRootNode; i++)
			{
				if (rootNodes.item(i).getNodeType() == Node.ELEMENT_NODE)
				{
					Element childElement = (Element) rootNodes.item(i);
					// Add the place
					if (childElement.getNodeName() == "Place")
					{
						place.setName(childElement.getAttribute("name"));
						place.setNumber(Integer.parseInt(childElement.getAttribute("number")));
						place.setStreet(childElement.getAttribute("street"));
						place.setCity(childElement.getAttribute("city"));
						place.setCountry(childElement.getAttribute("country"));
						place.setPostalCode(Integer.parseInt(childElement.getAttribute("postalCode")));
						NodeList childNodes = childElement.getChildNodes();
						int nbChildNode = childNodes.getLength();
						for (int k = 0; k < nbChildNode; k++)
						{
							if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE)
							{
								// Add gpsCoord into the place
								Element gpsElement = (Element) childNodes.item(k);
								place.setGpsCoord(new GpsCoord(Double.parseDouble(gpsElement.getAttribute("latitude")), Double.parseDouble(gpsElement.getAttribute("longitude"))));
							}
						}
						event.setPlace(place);
					}
					// Get the activities
					if (childElement.getNodeName() == "Activities")
					{
						NodeList activitiesNodes = childElement.getChildNodes();
						int nbActivitiesNode = activitiesNodes.getLength();
						for (int m = 0; m < nbActivitiesNode; m++)
						{
							// Get information for each activity
							if (activitiesNodes.item(m).getNodeType() == Node.ELEMENT_NODE)
							{
								activity = new Activity();
								Element activityElement = (Element) activitiesNodes.item(m);
								activity.setName(activityElement.getAttribute("name"));
								activity.setNumberMinimum(Integer.parseInt(activityElement.getAttribute("numberMinimum")));
								activity.setNumberMaximum(Integer.parseInt(activityElement.getAttribute("numberMaximum")));
								activity.setPrice(Double.parseDouble(activityElement.getAttribute("price")));
								activity.setDateBegin(dateFormat.parse(activityElement.getAttribute("dateBegin")));
								activity.setDateEnd(dateFormat.parse(activityElement.getAttribute("dateEnd")));
								activity.setDescription(activityElement.getAttribute("description"));
								NodeList organiserNodes = activityElement.getChildNodes();
								int nbOrganiserNode = organiserNodes.getLength();
								for (int n = 0; n < nbOrganiserNode; n++)
								{
									if (organiserNodes.item(n).getNodeType() == Node.ELEMENT_NODE)
									{
										// Get information about the organiser
										Element organiserElement = (Element) organiserNodes.item(n);
										organiser = new Organiser();
										organiser.setFirstName(organiserElement.getAttribute("firstName"));
										organiser.setLastName(organiserElement.getAttribute("lastName"));
										organiser.setClub(organiserElement.getAttribute("club"));
										organiser.setRole(organiserElement.getAttribute("role"));
										activity.setOrganiser(organiser);
									}
								}
								event.addActivity(activity);
							}
						}
					}
				}
			}

		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		
		// Refresh the window and panels
		MainWindow.getInstance().getWorkPanel().init();
		MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(false);
		MainWindow.getInstance().getWorkPanel().getViewEvent().getActivitiesPanel().setVisible(false);
		MainWindow.getInstance().getWorkPanel().getViewEvent().setEvent(event);
		MainWindow.getInstance().getWorkPanel().getViewEvent().show();
		MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(true);
		MainWindow.getInstance().getWorkPanel().getViewEvent().getActivitiesPanel().setVisible(true);
		MainWindow.getInstance().getToolsPanel().enableButtons();
	}

}
