import axios from "axios";
import { BASE_URL } from "./apiEndpoints.js";

const axiosConfig = axios.create({
    baseURL: BASE_URL,
    headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
    },
});

// list of endpoints that do NOT require the authorization token
const excludeEndpoints = ["/login", "/register", "/status", "/activate", "/health"];

// REQUEST INTERCEPTOR
axiosConfig.interceptors.request.use(
    (config) => {
        const shouldSkipToken = excludeEndpoints.some((endpoint) => {
            return config.url?.includes(endpoint);
        });

        if (!shouldSkipToken) {
            const accessToken = localStorage.getItem("token");
            if (accessToken) {
                config.headers.Authorization = `Bearer ${accessToken}`;
            }
        }

        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

// RESPONSE INTERCEPTOR
axiosConfig.interceptors.response.use(
    (response) => {
        return response;
    },
    (error) => {
        if (error.response) {
            const status = error.response.status;
            const path = window.location.pathname;

            // prevent redirect + toast on public pages
            const isPublicPage =
                path === "/" || path === "/home" || path === "/login" || path === "/signup";

            if (status === 401) {
                // only redirect if the user tries to access PROTECTED pages
                if (!isPublicPage) {
                    window.location.href = "/login";
                }
            }

            if (status === 500) {
                console.error("Server error. Please try again later");
            }
        } else if (error.code === "ECONNABORTED") {
            console.error("Request timeout. Please try again.");
        }

        return Promise.reject(error);
    }
);

export default axiosConfig;
