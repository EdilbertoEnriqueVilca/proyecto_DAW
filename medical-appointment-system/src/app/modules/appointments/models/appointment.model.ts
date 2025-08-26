// src/app/modules/appointments/models/appointment.model.ts
export interface PersonRef { id?: number; nombre?: string; }
export interface SpecialtyRef { id?: number; nombre?: string; }

export interface Appointment {
  codcit?: number;
  dates: Date | string;
  hour: string;
  estado: string;
  fechaCreate?: Date | string;
  customer: PersonRef | number;
  doctor: PersonRef | number;
  specialty: SpecialtyRef | number;
}
