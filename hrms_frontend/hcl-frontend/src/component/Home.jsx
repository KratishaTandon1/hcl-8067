import React from 'react';
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

const Home = () => {
    const isLoggedIn = !!localStorage.getItem("user");

    return (
        <div style={{ backgroundColor: '#f8fafc', minHeight: '100vh', display: 'flex', flexDirection: 'column' }}>
            {/* Top Navigation Bar */}
            <nav className="navbar navbar-expand-lg navbar-light bg-white border-bottom shadow-sm px-4 py-3">
                <div className="container d-flex justify-content-between align-items-center">
                    <div className="d-flex align-items-center gap-2">
                        <div style={{
                            width: '40px',
                            height: '40px',
                            backgroundColor: '#2563eb',
                            color: '#ffffff',
                            borderRadius: '10px',
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'center',
                            fontWeight: 'bold',
                            fontSize: '20px'
                        }}>
                            H
                        </div>
                        <span className="navbar-brand fw-bold text-dark mb-0 fs-5" style={{ letterSpacing: '0.5px' }}>
                            HRMS <span style={{ color: '#2563eb' }}>Portal</span>
                        </span>
                    </div>

                    <div className="d-flex align-items-center gap-3">
                        {isLoggedIn ? (
                            <Link to="/dashboard" className="btn btn-primary px-4 fw-semibold" style={{ backgroundColor: '#2563eb', borderColor: '#2563eb' }}>
                                Go to Dashboard →
                            </Link>
                        ) : (
                            <>
                                <Link to="/login" className="btn btn-outline-secondary px-3 fw-semibold">
                                    Sign In
                                </Link>
                                <Link to="/registeration" className="btn btn-primary px-4 fw-semibold shadow-sm" style={{ backgroundColor: '#2563eb', borderColor: '#2563eb' }}>
                                    Register
                                </Link>
                            </>
                        )}
                    </div>
                </div>
            </nav>

            {/* Hero Section */}
            <div className="container my-auto py-5">
                <div className="row align-items-center g-5 py-4">
                    <div className="col-lg-7 text-start">
                        <div className="badge bg-primary-subtle text-primary border border-primary-subtle px-3 py-2 rounded-pill mb-3 fw-semibold">
                            Enterprise Workforce Solution
                        </div>
                        <h1 className="display-4 fw-bold text-dark mb-3" style={{ letterSpacing: '-1px', lineHeight: '1.2' }}>
                            Smart, Simple & Seamless <span style={{ color: '#2563eb' }}>HR Attendance</span> Management
                        </h1>
                        <p className="lead text-secondary mb-4" style={{ fontSize: '1.15rem' }}>
                            Empower your workforce with instant attendance check-ins, employee profiling, and real-time activity dashboards backed by reliable MySQL data storage.
                        </p>
                        <div className="d-flex flex-wrap gap-3">
                            <Link
                                to={isLoggedIn ? "/dashboard" : "/login"}
                                className="btn btn-primary btn-lg px-4 py-3 fw-semibold shadow-sm"
                                style={{ backgroundColor: '#2563eb', borderColor: '#2563eb', borderRadius: '8px' }}
                            >
                                {isLoggedIn ? "Open Dashboard" : "Employee Login"} →
                            </Link>
                            <Link
                                to="/attendance"
                                className="btn btn-outline-dark btn-lg px-4 py-3 fw-semibold"
                                style={{ borderRadius: '8px' }}
                            >
                                Mark Attendance
                            </Link>
                        </div>
                    </div>

                    <div className="col-lg-5">
                        <div className="bg-white p-4 rounded-4 border shadow-sm">
                            <h5 className="fw-bold text-dark mb-3">Quick Navigation</h5>
                            <div className="d-flex flex-column gap-3">
                                <Link to="/login" className="p-3 rounded-3 border text-decoration-none d-flex align-items-center justify-content-between hover-shadow bg-light">
                                    <div>
                                        <div className="fw-bold text-dark">Employee Login</div>
                                        <small className="text-muted">Access your personalized workspace</small>
                                    </div>
                                    <span className="text-primary fw-bold">→</span>
                                </Link>
                                <Link to="/registeration" className="p-3 rounded-3 border text-decoration-none d-flex align-items-center justify-content-between hover-shadow bg-light">
                                    <div>
                                        <div className="fw-bold text-dark">New Registration</div>
                                        <small className="text-muted">Register a new employee profile</small>
                                    </div>
                                    <span className="text-primary fw-bold">→</span>
                                </Link>
                                <Link to="/attendance" className="p-3 rounded-3 border text-decoration-none d-flex align-items-center justify-content-between hover-shadow bg-light">
                                    <div>
                                        <div className="fw-bold text-dark">Daily Attendance Punch</div>
                                        <small className="text-muted">Record today's check-in / check-out</small>
                                    </div>
                                    <span className="text-primary fw-bold">→</span>
                                </Link>
                                <Link to="/dashboard" className="p-3 rounded-3 border text-decoration-none d-flex align-items-center justify-content-between hover-shadow bg-light">
                                    <div>
                                        <div className="fw-bold text-dark">Employee Dashboard</div>
                                        <small className="text-muted">View marked attendance history</small>
                                    </div>
                                    <span className="text-primary fw-bold">→</span>
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>

                {/* 3 Key Feature Cards */}
                <div className="row g-4 mt-2">
                    <div className="col-md-4">
                        <div className="bg-white p-4 rounded-3 border shadow-sm h-100 text-start">
                            <div style={{ width: '48px', height: '48px', borderRadius: '10px', backgroundColor: '#eff6ff', color: '#2563eb', display: 'flex', alignItems: 'center', justifyContent: 'center', fontSize: '22px', marginBottom: '16px' }}>
                                🕒
                            </div>
                            <h5 className="fw-bold text-dark mb-2">Automated Attendance</h5>
                            <p className="text-muted small mb-0">
                                Check in and check out effortlessly with automatic timestamp recording and validation against duplicate entries for the day.
                            </p>
                        </div>
                    </div>
                    <div className="col-md-4">
                        <div className="bg-white p-4 rounded-3 border shadow-sm h-100 text-start">
                            <div style={{ width: '48px', height: '48px', borderRadius: '10px', backgroundColor: '#f0fdf4', color: '#16a34a', display: 'flex', alignItems: 'center', justifyContent: 'center', fontSize: '22px', marginBottom: '16px' }}>
                                📊
                            </div>
                            <h5 className="fw-bold text-dark mb-2">Interactive Dashboard</h5>
                            <p className="text-muted small mb-0">
                                Get clear visibility into your historical attendance records, daily status, and employee details in one centralized view.
                            </p>
                        </div>
                    </div>
                    <div className="col-md-4">
                        <div className="bg-white p-4 rounded-3 border shadow-sm h-100 text-start">
                            <div style={{ width: '48px', height: '48px', borderRadius: '10px', backgroundColor: '#faf5ff', color: '#9333ea', display: 'flex', alignItems: 'center', justifyContent: 'center', fontSize: '22px', marginBottom: '16px' }}>
                                🛡️
                            </div>
                            <h5 className="fw-bold text-dark mb-2">Reliable Storage</h5>
                            <p className="text-muted small mb-0">
                                Powered by robust Spring Boot backend architecture and relational MySQL database persistence.
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            {/* Footer */}
            <footer className="bg-white border-top py-3 text-center text-muted small mt-auto">
                <div className="container">
                    HRMS Management System • Built with Spring Boot, React & MySQL
                </div>
            </footer>
        </div>
    );
};

export default Home;
