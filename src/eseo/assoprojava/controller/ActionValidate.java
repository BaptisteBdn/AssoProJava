package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.model.place.Place;
import eseo.assoprojava.model.place.gps.GpsCoord;
import eseo.assoprojava.view.ui.MainWindow;
import eseo.assoprojava.view.ui.panels.FormActivityPanel;
import eseo.assoprojava.view.ui.panels.FormPanel;

public class ActionValidate extends javax.swing.AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionValidate()
	{
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (MainWindow.getCurrentFormWindow().isEvent())
		{
			Event event = new Event();
			FormPanel formPanel = MainWindow.getCurrentFormWindow().getFormPanel();
			if (formPanel.getNameField().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le nom ne peut pas �tre vide !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!formPanel.getPlaceNumberField().getText().matches("[0-9]+") || !(formPanel.getPlaceNumberField().getText().length() > 0))
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le num�ro de rue est incorrect !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!formPanel.getPlacePostalCodeField().getText().matches("[0-9]+") || !(formPanel.getPlacePostalCodeField().getText().length() > 0))
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le code postal est incorrect !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (formPanel.getPlaceNameField().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le nom du lieu ne peut pas �tre vide !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!Pattern.matches(fpRegex, formPanel.getPlaceGPSLatField().getText()) && !formPanel.getPlaceGPSLatField().getText().equals(""))
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "La latitude n'est pas valide ! (Nombre ou vide)", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!Pattern.matches(fpRegex, formPanel.getPlaceGPSLongField().getText()) && !formPanel.getPlaceGPSLongField().getText().equals(""))
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "La longitude n'est pas valide ! (Nombre ou vide)", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!Pattern.matches(fpRegex, formPanel.getPriceField().getText()) && !formPanel.getPriceField().getText().equals(""))
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le prix n'est pas valide ! (Nombre ou vide)", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (formPanel.getClubField().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le nom du club ne peut pas �tre vide !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!((Date) formPanel.getDateEndField().getValue()).after((Date) formPanel.getDateBeginField().getValue()))
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "La date de fin ne doit pas �tre inf�rieur (ou �gal) � la date de d�but !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!formPanel.getNumberMinField().getText().matches("[0-9]+") || !(formPanel.getNumberMinField().getText().length() > 0) || formPanel.getNumberMinField().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le nombre de personnes minimum est incorrect !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!formPanel.getNumberMaxField().getText().matches("[0-9]+") && !formPanel.getNumberMaxField().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le nombre de personnes maximum est incorrect !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if(!formPanel.getNumberMaxField().getText().isEmpty()){
				event.setNumberMaximum(Integer.parseInt(formPanel.getNumberMaxField().getText()));
				if (Integer.parseInt(formPanel.getNumberMaxField().getText()) - Integer.parseInt(formPanel.getNumberMinField().getText()) < 0)
				{
					JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le nombre de personnes minimum ne peut pas �tre sup�rieur au nombre de personnes maximum !", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			} else {
				event.setNumberMaximum(0);
			}

			event.setName(formPanel.getNameField().getText());
			event.setClubOrganiser(formPanel.getClubField().getText());
			event.setDateBegin((Date) formPanel.getDateBeginField().getValue());
			event.setDateEnd((Date) formPanel.getDateEndField().getValue());
			event.setNumberMinimum(Integer.parseInt(formPanel.getNumberMinField().getText()));
			
			if(!formPanel.getPriceField().getText().equals("")){
				event.setPrice(Double.parseDouble(formPanel.getPriceField().getText()));
			} else {
				event.setPrice(0);
			}
			
			event.setPlace(new Place(Integer.parseInt(formPanel.getPlaceNumberField().getText()), 
				formPanel.getPlaceStreetField().getText(), 
				formPanel.getPlaceCityField().getText(), 
				formPanel.getPlaceStateField().getText(), 
				formPanel.getPlaceCountryField().getText(), 
				Integer.parseInt(formPanel.getPlacePostalCodeField().getText()),
				new GpsCoord(),
				formPanel.getPlaceNameField().getText()));
			event.setDescription(formPanel.getDescriptionField().getText());
			if(!formPanel.getPlaceGPSLatField().getText().equals("") && !formPanel.getPlaceGPSLongField().getText().equals("")){
				event.getPlace().setGpsCoord(new GpsCoord(Double.parseDouble(formPanel.getPlaceGPSLatField().getText()),Double.parseDouble(formPanel.getPlaceGPSLongField().getText())));
			}
			
			event.setActivities(MainWindow.getInstance().getWorkPanel().getViewEvent().getEvent().getActivities());
			
			MainWindow.getCurrentFormWindow().setVisible(false);
			MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(false);
			MainWindow.getInstance().getWorkPanel().getViewEvent().getActivitiesPanel().setVisible(false);
			MainWindow.getInstance().getWorkPanel().getViewEvent().setEvent(event);
			MainWindow.getInstance().getWorkPanel().getViewEvent().show();
			MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(true);
			MainWindow.getInstance().getWorkPanel().getViewEvent().getActivitiesPanel().setVisible(true);
			
		} else {
			Activity activity = MainWindow.getCurrentFormWindow().getFormActivityPanel().getActivity();
			FormActivityPanel f = MainWindow.getCurrentFormWindow().getFormActivityPanel();
			if (f.getNameField().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le nom ne peut pas �tre vide !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!Pattern.matches(fpRegex, f.getPriceField().getText()) && !f.getPriceField().getText().equals(""))
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le prix n'est pas valide ! (Nombre ou vide)", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (f.getOrganiserFirstField().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le pr�nom de l'animateur ne peut pas �tre vide !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (f.getOrganiserLastField().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le nom de l'animateur ne peut pas �tre vide !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!((Date) f.getDateEndField().getValue()).after((Date) f.getDateBeginField().getValue()))
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "La date de fin ne doit pas �tre inf�rieur (ou �gal) � la date de d�but !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!f.getNumberMinField().getText().matches("[0-9]+") || !(f.getNumberMinField().getText().length() > 0) || f.getNumberMinField().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le nombre de personnes minimum est incorrect !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!f.getNumberMaxField().getText().matches("[0-9]+") && !f.getNumberMaxField().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le nombre de personnes maximum est incorrect !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			activity.setName(f.getNameField().getText());
			activity.setDateBegin((Date) f.getDateBeginField().getValue());
			activity.setDateEnd((Date) f.getDateEndField().getValue());
			activity.setDescription(f.getDescriptionField().getText());
			
			if(!f.getPriceField().getText().equals("")){
				activity.setPrice(Double.parseDouble(f.getPriceField().getText()));
			} else {
				activity.setPrice(0);
			}			
			
			activity.setNumberMinimum(Integer.parseInt(f.getNumberMinField().getText()));
			
			if(!f.getNumberMaxField().getText().isEmpty()){
				activity.setNumberMaximum(Integer.parseInt(f.getNumberMaxField().getText()));
				if (Integer.parseInt(f.getNumberMaxField().getText()) - Integer.parseInt(f.getNumberMinField().getText()) < 0)
				{
					JOptionPane.showMessageDialog(MainWindow.getCurrentFormWindow(), "Le nombre de personnes minimum ne peut pas �tre sup�rieur au nombre de personnes maximum !", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			} else {
				activity.setNumberMaximum(0);
			}
			
			if( MainWindow.getCurrentFormWindow().getFormActivityPanel().isCreating()){
				Event event = MainWindow.getInstance().getWorkPanel().getViewEvent().getEvent();
				event.addActivity(activity);
				MainWindow.getInstance().getWorkPanel().getViewEvent().setEvent(event);
			}
			
			MainWindow.getCurrentFormWindow().setVisible(false);
			MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(false);
			MainWindow.getInstance().getWorkPanel().getViewEvent().getActivitiesPanel().setVisible(false);
			MainWindow.getInstance().getWorkPanel().getViewEvent().show();
			MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(true);
			MainWindow.getInstance().getWorkPanel().getViewEvent().getActivitiesPanel().setVisible(true);
		}
	}

	final String Digits = "(\\p{Digit}+)";
	final String HexDigits = "(\\p{XDigit}+)";
	final String Exp = "[eE][+-]?" + Digits;
	final String fpRegex = ("[\\x00-\\x20]*" + // Optional leading "whitespace"
		"[+-]?(" + // Optional sign character
		"NaN|" + // "NaN" string
		"Infinity|" + // "Infinity" string

		// A decimal floating-point string representing a finite positive
		// number without a leading sign has at most five basic pieces:
		// Digits . Digits ExponentPart FloatTypeSuffix
		//
		// Since this method allows integer-only strings as input
		// in addition to strings of floating-point literals, the
		// two sub-patterns below are simplifications of the grammar
		// productions from the Java Language Specification, 2nd
		// edition, section 3.10.2.

		// Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
		"(((" + Digits + "(\\.)?(" + Digits + "?)(" + Exp + ")?)|" +

		// . Digits ExponentPart_opt FloatTypeSuffix_opt
		"(\\.(" + Digits + ")(" + Exp + ")?)|" +

		// Hexadecimal strings
		"((" +
		// 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
		"(0[xX]" + HexDigits + "(\\.)?)|" +

		// 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
		"(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

		")[pP][+-]?" + Digits + "))" + "[fFdD]?))" + "[\\x00-\\x20]*");// Optional
																		// trailing
																		// "whitespace"

}
