package com.bridgelabz.service;

import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;

public interface ICliniqueUtil {

	public void readJson();

	Doctor getDoctor();

	void addDoctor(Doctor doctor);

	Patient getPatient();

	public void addPatient(Patient patient);

	public void searchDoctorById();

	public void searchDoctorByName();

	public String getDoctorName();

	public boolean searchDoctorBySpecialization(String str);

	public boolean searchDoctorByAvailability(String str, int time);

	public boolean searchPatientById(int num);

	public void searchPatientByName();

	public void searchPatientByMobile();

	public void addAppointment();

	void validatedCriteria();

	public void save();

	public void showAllRecords();

	public void showPopularDoctor();

	public void sortDoctorList();

	void showDoctorList(int index, boolean hasSigleRecord);

	void showPatientList(int index, boolean hasSingleRecord);

	public void showDoctorList(int index, int num);

	Appointment getAppointment(int index, int patientId);

	int getPatientIndexById(int patientId);

	void savingAppointment(Appointment appointment);

}
