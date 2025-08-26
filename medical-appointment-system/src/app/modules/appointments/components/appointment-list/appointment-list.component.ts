import { Component, OnInit } from '@angular/core';
import { NgIf, NgFor } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { AppointmentDTO } from '../../models/appointment-dto.model';
import { AppointmentService } from '../../services/appointment.service';

@Component({
  selector: 'app-appointment-list',
  standalone: true,
  imports: [NgIf, NgFor, RouterModule], // *ngIf, *ngFor, routerLink
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {
  appointments: AppointmentDTO[] = [];
  loading = true;

  constructor(private service: AppointmentService, private router: Router) {}

  ngOnInit(): void { this.loadAppointments(); }

  loadAppointments(): void {
    this.loading = true;
    this.service.getAll().subscribe({
      next: (data) => { this.appointments = data; this.loading = false; },
      error: (err) => { console.error('Error loading appointments', err); this.loading = false; }
    });
  }

  edit(id: number): void { this.router.navigate(['/appointments/edit', id]); }

  delete(id: number): void {
    if (confirm('¿Está seguro de eliminar esta cita?')) {
      this.service.delete(id).subscribe({
        next: () => this.appointments = this.appointments.filter(a => a.codcit !== id),
        error: (err) => console.error('Error deleting appointment', err)
      });
    }
  }

  formatDate(date: any): string { return new Date(date).toLocaleDateString('es-ES'); }
}
