import React, { useEffect, useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

function Dashboard() {
    const [user, setUser] = useState(null);
    const [attendances, setAttendances] = useState([]);
    const [searchQuery, setSearchQuery] = useState('');
    const [loading, setLoading] = useState(true);
    const navigate = useNavigate();

    useEffect(() => {
        const storedUser = localStorage.getItem("user");
        if (!storedUser) {
            navigate("/login");
            return;
        }

        const parsedUser = JSON.parse(storedUser);
        setUser(parsedUser);
        fetchAttendance(parsedUser.empid);
    }, [navigate]);

    async function fetchAttendance(empid) {
        try {
            setLoading(true);
            const response = await fetch(`http://localhost:8080/v1/user/attendance/employee/${empid}`);
            if (response.ok) {
                const data = await response.json();
                setAttendances(data);
            } else {
                console.error("Failed to fetch attendance");
            }
        } catch (error) {
            console.error("Error fetching attendance:", error);
        } finally {
            setLoading(false);
        }
    }

    function handleLogout() {
        localStorage.removeItem("user");
        navigate("/login");
    }

    function formatDateTime(dateTimeStr) {
        if (!dateTimeStr) return "-";
        try {
            const date = new Date(dateTimeStr);
            if (isNaN(date.getTime())) return dateTimeStr;
            return date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' }) +
                " (" + date.toLocaleDateString() + ")";
        } catch {
            return dateTimeStr;
        }
    }

    // Today's status check
    const todayStr = new Date().toISOString().split('T')[0];
    const isTodayMarked = attendances.some(att => att.attendancedate === todayStr);

    // Search / Filter
    const filteredAttendances = attendances.filter(att => {
        const query = searchQuery.toLowerCase();
        return (
            (att.attendancedate && att.attendancedate.toLowerCase().includes(query)) ||
            (att.comment && att.comment.toLowerCase().includes(query))
        );
    });

    return (
        <div style={{ backgroundColor: '#f8fafc', minHeight: '100vh', display: 'flex', flexDirection: 'column' }}>
            {/* Classic Clean Navigation Bar */}
            <nav className="navbar navbar-expand-lg navbar-light bg-white border-bottom shadow-sm px-4 py-3">
                <div className="container-fluid d-flex justify-content-between align-items-center">
                    <Link to="/" className="d-flex align-items-center gap-2 text-decoration-none">
                        <div style={{
                            width: '38px',
                            height: '38px',
                            backgroundColor: '#2563eb',
                            color: '#ffffff',
                            borderRadius: '8px',
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'center',
                            fontWeight: 'bold',
                            fontSize: '18px'
                        }}>
                            H
                        </div>
                        <span className="navbar-brand fw-bold text-dark mb-0 fs-5" style={{ letterSpacing: '0.5px' }}>
                            HRMS <span style={{ color: '#2563eb' }}>Portal</span>
                        </span>
                    </Link>

                    <div className="d-flex align-items-center gap-3">
                        {user && (
                            <div className="d-flex align-items-center gap-2 bg-light px-3 py-1 rounded-pill border">
                                <div style={{
                                    width: '28px',
                                    height: '28px',
                                    borderRadius: '50%',
                                    backgroundColor: '#e0e7ff',
                                    color: '#3730a3',
                                    display: 'flex',
                                    alignItems: 'center',
                                    justifyContent: 'center',
                                    fontSize: '13px',
                                    fontWeight: '600'
                                }}>
                                    {user.emp_name ? user.emp_name.charAt(0).toUpperCase() : 'U'}
                                </div>
                                <span className="small fw-semibold text-secondary">
                                    {user.emp_name} ({user.designation || 'Employee'})
                                </span>
                            </div>
                        )}
                        <button
                            onClick={handleLogout}
                            className="btn btn-outline-danger btn-sm px-3 fw-medium"
                            style={{ borderRadius: '6px' }}
                        >
                            Logout
                        </button>
                    </div>
                </div>
            </nav>

            <div className="container py-4 flex-grow-1 text-start">
                {/* Greeting & Header Banner */}
                <div className="bg-white p-4 rounded-3 border shadow-sm mb-4 d-flex flex-column flex-md-row justify-content-between align-items-md-center gap-3">
                    <div>
                        <h3 className="fw-bold text-dark mb-1">
                            Welcome back, {user ? user.emp_name : 'Employee'} 👋
                        </h3>
                        <p className="text-muted mb-0 small">
                            Here is an overview of your work profile and marked attendance history.
                        </p>
                    </div>
                    <div className="d-flex gap-2">
                        <button
                            onClick={() => user && fetchAttendance(user.empid)}
                            className="btn btn-outline-secondary btn-sm px-3"
                            title="Refresh records"
                        >
                            ↻ Refresh
                        </button>
                        <Link
                            to="/attendance"
                            className="btn btn-primary btn-sm px-3 fw-semibold shadow-sm"
                            style={{ backgroundColor: '#2563eb', borderColor: '#2563eb' }}
                        >
                            + Mark Attendance
                        </Link>
                    </div>
                </div>

                {/* Stat Cards Row */}
                <div className="row g-3 mb-4">
                    <div className="col-12 col-sm-6 col-lg-3">
                        <div className="bg-white p-3 rounded-3 border shadow-sm h-100">
                            <span className="text-muted small fw-medium text-uppercase" style={{ letterSpacing: '0.5px' }}>Employee ID</span>
                            <h4 className="fw-bold text-dark mt-2 mb-0">#{user ? user.empid : '-'}</h4>
                        </div>
                    </div>
                    <div className="col-12 col-sm-6 col-lg-3">
                        <div className="bg-white p-3 rounded-3 border shadow-sm h-100">
                            <span className="text-muted small fw-medium text-uppercase" style={{ letterSpacing: '0.5px' }}>Department / Stack</span>
                            <h5 className="fw-bold text-dark mt-2 mb-0">{user ? user.stack : '-'}</h5>
                        </div>
                    </div>
                    <div className="col-12 col-sm-6 col-lg-3">
                        <div className="bg-white p-3 rounded-3 border shadow-sm h-100">
                            <span className="text-muted small fw-medium text-uppercase" style={{ letterSpacing: '0.5px' }}>Total Days Present</span>
                            <h4 className="fw-bold text-primary mt-2 mb-0">{attendances.length}</h4>
                        </div>
                    </div>
                    <div className="col-12 col-sm-6 col-lg-3">
                        <div className="bg-white p-3 rounded-3 border shadow-sm h-100">
                            <span className="text-muted small fw-medium text-uppercase" style={{ letterSpacing: '0.5px' }}>Today's Status</span>
                            <div className="mt-2">
                                {isTodayMarked ? (
                                    <span className="badge bg-success-subtle text-success border border-success-subtle px-2 py-1 fs-6 fw-semibold">
                                        ✓ Marked Today
                                    </span>
                                ) : (
                                    <span className="badge bg-warning-subtle text-warning-emphasis border border-warning-subtle px-2 py-1 fs-6 fw-semibold">
                                        Pending
                                    </span>
                                )}
                            </div>
                        </div>
                    </div>
                </div>

                {/* Attendance Table Card */}
                <div className="bg-white rounded-3 border shadow-sm">
                    <div className="p-3 border-bottom d-flex flex-column flex-sm-row justify-content-between align-items-sm-center gap-2">
                        <div className="d-flex align-items-center gap-2">
                            <h5 className="fw-bold text-dark mb-0">Attendance Log</h5>
                            <span className="badge bg-light text-secondary border">
                                {filteredAttendances.length} of {attendances.length} Entries
                            </span>
                        </div>
                        {attendances.length > 0 && (
                            <div style={{ maxWidth: '250px' }}>
                                <input
                                    type="text"
                                    className="form-control form-control-sm"
                                    placeholder="🔍 Search date or note..."
                                    value={searchQuery}
                                    onChange={(e) => setSearchQuery(e.target.value)}
                                />
                            </div>
                        )}
                    </div>

                    <div className="p-0">
                        {loading ? (
                            <div className="text-center py-5">
                                <div className="spinner-border text-primary spinner-border-sm me-2" role="status"></div>
                                <span className="text-muted small">Loading your attendance records...</span>
                            </div>
                        ) : attendances.length === 0 ? (
                            <div className="text-center py-5">
                                <div className="text-muted mb-3" style={{ fontSize: '32px' }}>📅</div>
                                <h6 className="fw-semibold text-secondary">No attendance recorded yet</h6>
                                <p className="text-muted small mb-3">Mark your first attendance to view history here.</p>
                                <Link to="/attendance" className="btn btn-outline-primary btn-sm px-3">
                                    Mark Attendance Now
                                </Link>
                            </div>
                        ) : filteredAttendances.length === 0 ? (
                            <div className="text-center py-4">
                                <p className="text-muted mb-0">No records found matching "{searchQuery}"</p>
                            </div>
                        ) : (
                            <div className="table-responsive">
                                <table className="table table-hover align-middle mb-0" style={{ fontSize: '14px' }}>
                                    <thead style={{ backgroundColor: '#f1f5f9', color: '#475569' }}>
                                        <tr>
                                            <th className="py-3 px-3 fw-semibold">#</th>
                                            <th className="py-3 px-3 fw-semibold">Date</th>
                                            <th className="py-3 px-3 fw-semibold">In Time</th>
                                            <th className="py-3 px-3 fw-semibold">Out Time</th>
                                            <th className="py-3 px-3 fw-semibold">Comment / Note</th>
                                            <th className="py-3 px-3 fw-semibold text-center">Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {filteredAttendances.map((item, index) => (
                                            <tr key={item.attendanceId || index} style={{ borderBottom: '1px solid #f1f5f9' }}>
                                                <td className="px-3 text-muted">{index + 1}</td>
                                                <td className="px-3 fw-medium text-dark">
                                                    {item.attendancedate}
                                                </td>
                                                <td className="px-3 text-secondary">
                                                    {formatDateTime(item.inTime)}
                                                </td>
                                                <td className="px-3 text-secondary">
                                                    {formatDateTime(item.outTime)}
                                                </td>
                                                <td className="px-3 text-muted">
                                                    {item.comment || <span className="text-black-50">—</span>}
                                                </td>
                                                <td className="px-3 text-center">
                                                    <span className="badge bg-success-subtle text-success px-2 py-1 fw-medium" style={{ fontSize: '12px' }}>
                                                        Recorded
                                                    </span>
                                                </td>
                                            </tr>
                                        ))}
                                    </tbody>
                                </table>
                            </div>
                        )}
                    </div>
                </div>
            </div>

            <footer className="bg-white border-top py-3 text-center text-muted small mt-auto">
                HRMS Management System • Employee Dashboard
            </footer>
        </div>
    );
}

export default Dashboard;
