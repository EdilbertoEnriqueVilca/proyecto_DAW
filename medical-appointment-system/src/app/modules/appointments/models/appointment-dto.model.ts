export interface AppointmentDTO {
  codcit: number;
  dates: Date | string;
  hour: string;
  estado: string;
  fechaCreate: Date | string;
  patientName: string;
  doctorName: string;
  specialtyName: string;
}