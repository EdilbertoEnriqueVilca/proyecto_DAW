import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'appointments',
    loadChildren: () =>
      import('./modules/appointments/appointments.module')
        .then(m => m.AppointmentsModule)
  },
  { path: '', redirectTo: 'appointments', pathMatch: 'full' },
  { path: '**', redirectTo: 'appointments' }
];
